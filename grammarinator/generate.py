# Copyright (c) 2017-2023 Renata Hodovan, Akos Kiss.
#
# Licensed under the BSD 3-Clause License
# <LICENSE.rst or https://opensource.org/licenses/BSD-3-Clause>.
# This file may not be copied, modified, or distributed except
# according to those terms.

import glob
import json
import os
import random

from argparse import ArgumentParser, ArgumentTypeError, SUPPRESS
from functools import partial
from itertools import count
from math import inf
from multiprocessing import Manager, Pool
from os.path import abspath, exists, join

from inators.arg import add_log_level_argument, add_sys_path_argument, add_sys_recursion_limit_argument, add_version_argument, process_log_level_argument, process_sys_path_argument, process_sys_recursion_limit_argument
from inators.imp import import_object

from .cli import add_encoding_argument, add_encoding_errors_argument, add_tree_format_argument, add_jobs_argument, import_list, init_logging, logger, process_tree_format_argument, add_iteration_arguments, validate_iteration_arguments
from .pkgdata import __version__
from .runtime import RuleSize
from .tool import DefaultGeneratorFactory, DefaultPopulation, GeneratorTool
import coverage
import io
import sys
import importlib.util
import shutil

def clear_folder(folder_path):
    # Ensure the folder exists
    if os.path.exists(folder_path):
        for item in os.listdir(folder_path):
            item_path = os.path.join(folder_path, item)
            # Remove files and directories directly
            if os.path.isdir(item_path):
                shutil.rmtree(item_path)  # Remove directory and its contents
            else:
                os.remove(item_path)  # Remove file


def restricted_float(value):
    value = float(value)
    if value <= 0.0 or value > 1.0:
        raise ArgumentTypeError(f'{value!r} not in range (0.0, 1.0]')
    return value


def process_args(args):
    args.generator = import_object(args.generator)
    args.model = import_object(args.model)
    args.listener = import_list(args.listener)
    args.transformer = import_list(args.transformer)
    args.serializer = import_object(args.serializer) if args.serializer else None

    if args.weights:
        if not exists(args.weights):
            raise ValueError('Custom weights should point to an existing JSON file.')

        with open(args.weights, 'r') as f:
            weights = {}
            for rule, alts in json.load(f).items():
                for alternation_idx, alternatives in alts.items():
                    for alternative_idx, w in alternatives.items():
                        weights[(rule, int(alternation_idx), int(alternative_idx))] = w
            args.weights = weights
    else:
        args.weights = {}

    if args.population:
        args.population = abspath(args.population)


def generator_tool_helper(args, weights, lock):
    return GeneratorTool(generator_factory=DefaultGeneratorFactory(args.generator,
                                                                   model_class=args.model,
                                                                   cooldown=args.cooldown,
                                                                   weights=weights,
                                                                   lock=lock,
                                                                   listener_classes=args.listener),
                         rule=args.rule, out_format=args.out,
                         limit=RuleSize(depth=args.max_depth, tokens=args.max_tokens),
                         population=DefaultPopulation(args.population, args.tree_extension, args.tree_codec) if args.population else None,
                         generate=args.generate, mutate=args.mutate, recombine=args.recombine, keep_trees=args.keep_trees,
                         transformers=args.transformer, serializer=args.serializer,
                         cleanup=False, encoding=args.encoding, errors=args.encoding_errors, dry_run=args.dry_run)


def create_test(generator_tool, index, *, seed):
    if seed:
        random.seed(seed + index)
    return generator_tool.create(index)


def execute():
    target_loc = './target/'
    parser = ArgumentParser(description='Grammarinator: Generate', epilog="""
        The tool acts as a default execution harness for generators
        created by Grammarinator:Processor.
        """)
    # Settings for generating from grammar.
    parser.add_argument('generator', metavar='NAME',
                        help='reference to the generator created by grammarinator-process (in package.module.class format).')
    parser.add_argument('-r', '--rule', metavar='NAME',
                        help='name of the rule to start generation from (default: the parser rule set by grammarinator-process).')
    parser.add_argument('-m', '--model', metavar='NAME', default='grammarinator.runtime.DefaultModel',
                        help='reference to the decision model (in package.module.class format) (default: %(default)s).')
    parser.add_argument('-l', '--listener', metavar='NAME', action='append', default=[],
                        help='reference to a listener (in package.module.class format).')
    parser.add_argument('-t', '--transformer', metavar='NAME', action='append', default=[],
                        help='reference to a transformer (in package.module.function format) to postprocess the generated tree '
                             '(the result of these transformers will be saved into the serialized tree, e.g., variable matching).')
    parser.add_argument('-s', '--serializer', metavar='NAME',
                        help='reference to a seralizer (in package.module.function format) that takes a tree and produces a string from it.')
    parser.add_argument('-d', '--max-depth', default=RuleSize.max.depth, type=int, metavar='NUM',
                        help='maximum recursion depth during generation (default: %(default)f).')
    parser.add_argument('--max-tokens', default=RuleSize.max.tokens, type=int, metavar='NUM',
                        help='maximum token number during generation (default: %(default)f).')
    parser.add_argument('-c', '--cooldown', default=1.0, type=restricted_float, metavar='NUM',
                        help='cool-down factor defines how much the probability of an alternative should decrease '
                             'after it has been chosen (interval: (0, 1]; default: %(default)f).')
    parser.add_argument('-w', '--weights', metavar='FILE',
                        help='JSON file defining custom weights for alternatives.')

    # Evolutionary settings.
    parser.add_argument('--population', metavar='DIR',
                        help='directory of grammarinator tree pool.')
    parser.add_argument('--no-generate', dest='generate', default=True, action='store_false',
                        help='disable test generation from grammar.')
    parser.add_argument('--no-mutate', dest='mutate', default=True, action='store_false',
                        help='disable test generation by mutation (disabled by default if no population is given).')
    parser.add_argument('--no-recombine', dest='recombine', default=True, action='store_false',
                        help='disable test generation by recombination (disabled by default if no population is given).')
    parser.add_argument('--keep-trees', default=False, action='store_true',
                        help='keep generated tests to participate in further mutations or recombinations (only if population is given).')
    add_tree_format_argument(parser)
    add_iteration_arguments(parser)

    # Auxiliary settings.
    parser.add_argument('--clean-gen', action="store_true", help="remove all previously generated tests in ./target/tests folder.")
    parser.add_argument('-o', '--out', metavar='FILE', default=join(target_loc, 'tests', 'test_%d.html'),
                        help='output file name pattern (default: %(default)s).')
    parser.add_argument('--stdout', dest='out', action='store_const', const='', default=SUPPRESS,
                        help='print test cases to stdout (alias for --out=%(const)r)')
    parser.add_argument('-n', default=1, type=int, metavar='NUM',
                        help='number of tests to generate, \'inf\' for continuous generation (default: %(default)s).')
    parser.add_argument('--random-seed', type=int, metavar='NUM',
                        help='initialize random number generator with fixed seed (not set by default).')
    parser.add_argument('--dry-run', default=False, action='store_true',
                        help='generate tests without writing them to file or printing to stdout (do not keep generated tests in population either)')
    parser.add_argument('--no-gen', default=False, action='store_true', help="Don't generate any new test cases.")
    add_encoding_argument(parser, help='output file encoding (default: %(default)s).')
    add_encoding_errors_argument(parser)
    add_jobs_argument(parser)
    add_sys_path_argument(parser)
    add_sys_recursion_limit_argument(parser)
    add_log_level_argument(parser, short_alias=())
    add_version_argument(parser, version=__version__)
    args = parser.parse_args()

    if not args.sys_path:
        args.sys_path = [target_loc]

    # validate arguments for iteration mode

    init_logging()
    process_log_level_argument(args, logger)
    process_sys_path_argument(args)
    process_sys_recursion_limit_argument(args)
    process_tree_format_argument(args)
    try:
        process_args(args)
        validate_iteration_arguments(args, target_loc)
    except ValueError as e:
        parser.error(e)
    
    if args.clean_gen:
        clear_folder(join(target_loc, 'tests'))

    args.out = args.out.replace('\\', '/')
    folders, filename = split_out_pattern(args.out)
    file_path = join(target_loc, args.start_filename)
    dump = io.StringIO()
    # Path to the Python file
    spec = importlib.util.spec_from_file_location("target", file_path)
    if not spec or not spec.loader:
        raise Exception('???')
    target = importlib.util.module_from_spec(spec)
    original_stdout = sys.stdout

    cov = coverage.Coverage(source=[target_loc], omit="*Generator.py", branch=not args.stmt_cov)
    cov.start()

    if args.iterative:
        iter = 0
        stale_iter = 0
        pre_coverage = 0

        max_stale_iter = args.max_stale_iter if args.max_stale_iter else 10
        while pre_coverage < args.coverage_goal and stale_iter < max_stale_iter:
            args.out = f'{folders}iter_{iter}_{filename}'
            if not args.no_gen:
                if args.jobs > 1:
                    with Manager() as manager:
                        with generator_tool_helper(args, weights=manager.dict(args.weights), lock=manager.Lock()) as generator_tool:  # pylint: disable=no-member
                            parallel_create_test = partial(create_test, generator_tool, seed=args.random_seed)
                            with Pool(args.jobs) as pool:
                                for _ in pool.imap_unordered(parallel_create_test, count(0) if args.n == inf else range(args.n)):
                                    pass

                else:
                    with generator_tool_helper(args, weights=args.weights, lock=None) as generator_tool:
                        for i in count(0) if args.n == inf else range(args.n):
                            create_test(generator_tool, i, seed=args.random_seed)
            try:
                file_list = glob.glob(f'{folders}iter_{iter}_*')
                print(f"\tExecuting {file_path} with the {len(file_list)} files generated during iter {iter}.")
                for input_file_path in file_list:
                    with open(input_file_path, "r") as input_file:
                        file_contents = input_file.read().strip()
                        # Simulate command-line arguments
                        sys.argv = [file_path, file_contents]  # Pass file content as argument

                        # Execute the module
                        sys.stdout = dump
                        spec.loader.exec_module(target)
                        sys.stdout = original_stdout
            except ValueError:
                pass
            cur_coverage = cov.report(file=dump)
            print(f'At iter {iter}, overall coverage is {cur_coverage:.2f}%.')
            if cur_coverage == pre_coverage:
                stale_iter += 1
            else:
                stale_iter = 0
            pre_coverage = cur_coverage
            iter += 1
        cov.stop()
        cov.report(show_missing=True)
    else:
        args.out = f'{folders}_{filename}'
        if not args.no_gen:
            if args.jobs > 1:
                with Manager() as manager:
                    with generator_tool_helper(args, weights=manager.dict(args.weights), lock=manager.Lock()) as generator_tool:  # pylint: disable=no-member
                        parallel_create_test = partial(create_test, generator_tool, seed=args.random_seed)
                        with Pool(args.jobs) as pool:
                            for _ in pool.imap_unordered(parallel_create_test, count(0) if args.n == inf else range(args.n)):
                                pass
            else:
                with generator_tool_helper(args, weights=args.weights, lock=None) as generator_tool:
                    for i in count(0) if args.n == inf else range(args.n):
                        create_test(generator_tool, i, seed=args.random_seed)
        
        try:
            file_list = glob.glob(f'{folders}*')
            print(f"\tExecuting {file_path} with the {len(file_list)} generated files.")
            for input_file_path in file_list:
                with open(input_file_path, "r") as input_file:
                    file_contents = input_file.read().strip()
                    # Simulate command-line arguments
                    sys.argv = [file_path, input_file_path]  # Pass file content as argument

                    # Execute the module
                    sys.stdout = dump
                    spec.loader.exec_module(target)
                    sys.stdout = original_stdout
        except ValueError:
            pass
        cov.stop()
        cov.report(show_missing=True)
def split_out_pattern(path):
    idx = path.rfind('/')
    if idx != -1:
        first_part = path[:idx + 1]
        second_part = path[idx + 1:]
    else:
        first_part = ''
        second_part = path
    return first_part, second_part



if __name__ == '__main__':
    execute()
