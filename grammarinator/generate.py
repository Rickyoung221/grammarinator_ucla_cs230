# Copyright (c) 2017-2023 Renata Hodovan, Akos Kiss.
#
# Licensed under the BSD 3-Clause License
# <LICENSE.rst or https://opensource.org/licenses/BSD-3-Clause>.
# This file may not be copied, modified, or distributed except
# according to those terms.

import glob
import json
import math
import os
import random
import pprint

from argparse import ArgumentParser, ArgumentTypeError, SUPPRESS
from functools import partial
from itertools import count
from math import inf
from multiprocessing import Manager, Pool
from os.path import abspath, exists, join

from inators.arg import add_log_level_argument, add_sys_path_argument, add_sys_recursion_limit_argument, add_version_argument, process_log_level_argument, process_sys_path_argument, process_sys_recursion_limit_argument
from inators.imp import import_object
import numpy as np

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

def get_weights(args, pre_coverage, cur_coverage):
    if not args.iterative or not args.weighted_gen:
        return {}
    if pre_coverage == 0:
        return {}
    temperature = (cur_coverage - pre_coverage) / (100 - pre_coverage)
    if not args.positive_temp_softmax:
        temperature = 1-temperature
    with open('target/config/trace.json', 'r') as f:
        trace = json.load(f)
        raw_weights = calc_weights(trace, temperature=temperature)
        weights = {}
        for rule, alts in raw_weights.items():
            for alternation_idx, alternatives in alts.items():
                for alternative_idx, w in alternatives.items():
                    alts: dict = weights.setdefault(rule, {})
                    alternatives: dict = alts.setdefault(alternation_idx, {})
                    alternatives.setdefault(alternative_idx, w)
        if args.show_trace:
            print(f'cur: {cur_coverage:.2f}, pre: {pre_coverage:.2f}')
            print(f'improve is {cur_coverage - pre_coverage:.2f}')
            print(f'temperature is:{temperature :.2f}')
            print('trace is:')
            pprint.pprint(trace, compact=True, indent=2)
            print('weights are:')
            pprint.pprint(convert_to_float(weights), compact=True, indent=2)
        return weights

def convert_to_float(data):
    """
    Recursively converts all np.float64 values in a nested dictionary to native Python float.
    """
    if isinstance(data, dict):
        return {k: convert_to_float(v) for k, v in data.items()}
    elif isinstance(data, np.float64):
        return round(float(data), 2)
    elif isinstance(data, list):
        return [convert_to_float(v) for v in data]
    else:
        return data

def calc_weights(trace, temperature=1.0):
    """
    Apply softmax-based scaling with decay to the weights in a nested JSON structure.
    """
    # Traverse the JSON and apply scaling with decay
    weights = {}
    for key, sub_dict in trace.items():
        for sub_key, counts in sub_dict.items():
            weights.setdefault(key, {})
            weights[key][sub_key] = softmax_scaling(counts, temperature)
    return weights

def softmax_scaling(counts, temperature, alpha=2, beta=2, decay_factor=1.0, threshold=0.1):
    """
    Temperature-modulated softmax scaling with decay.

    Parameters:
    - counts (dict): Original counts for weights.
    - alpha (float): Controls sharpness of the inverse scaling.
    - beta (float): Controls sharpness of the softmax scaling.
    - decay_factor (float): Decays the counts before scaling.
    - temperature (float): Controls the interpolation:
        - High temperature (> threshold): Approaches standard softmax.
        - Near threshold: Flattens the distribution.
        - Low temperature (< threshold): Approaches inverse softmax.

    Returns:
    - scaled_weights (dict): A dictionary of scaled probabilities.
    """
    # Decay weights
    decayed_weights = {k: v * decay_factor for k, v in counts.items()}
    mean = np.mean(list(decayed_weights.values()))
    
    # Stabilized softmax with beta
    softmax_exponents = {k: beta * (v - mean) for k, v in decayed_weights.items()}
    max_softmax_val = max(softmax_exponents.values())
    softmax_weights = {
        k: np.exp(softmax_exponents[k] - max_softmax_val) for k in decayed_weights
    }
    total_softmax = sum(softmax_weights.values())
    softmax_scaled = {k: v / total_softmax for k, v in softmax_weights.items()}
    
    # Stabilized inverse softmax with alpha
    inverse_exponents = {k: -alpha * (v - mean) for k, v in decayed_weights.items()}
    max_inverse_val = max(inverse_exponents.values())
    inverse_softmax_weights = {
        k: np.exp(inverse_exponents[k] - max_inverse_val) for k in decayed_weights
    }
    total_inverse_softmax = sum(inverse_softmax_weights.values())
    inverse_softmax_scaled = {
        k: v / total_inverse_softmax for k, v in inverse_softmax_weights.items()
    }
    
    # Flat distribution
    flat_distribution = {k: 1 / len(counts) for k in counts}
    
    # Interpolation between distributions
    if temperature > threshold:
        # Interpolate between softmax and flat distribution
        normalized_temp = (temperature - threshold) / (1 - threshold)
        weight_factor = 1 if normalized_temp > 0.25 else 4*normalized_temp
        scaled_weights = {
            k: weight_factor * softmax_scaled[k] + (1 - weight_factor) * flat_distribution[k]
            for k in counts
        }
    else:
        # Interpolate between inverse softmax and flat distribution
        weight_factor = temperature / threshold
        scaled_weights = {
            k: (1 - weight_factor) * inverse_softmax_scaled[k] + weight_factor * flat_distribution[k]
            for k in counts
        }
    
    return scaled_weights

def reset_trace():
    with open("target/config/trace.json", 'w') as f:
        json.dump({}, f, indent=2) 
        f.flush()  # Flush the internal buffer to the OS buffer
        os.fsync(f.fileno())  # Flush the OS buffer to the disk

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
    parser.add_argument('-w', '--weighted-gen', action='store_true',
                        help='enable weighted generation for alternatives.')

    # Evolutionary settings.
    parser.add_argument('--population', metavar='DIR',
                        help='directory of grammarinator tree pool.')
    parser.add_argument('--no-generate', dest='generate', default=True, action='store_false',
                        help='disable test generation from grammar.')
    parser.add_argument('--no-mutate', dest='mutate', default=True, action='store_false',
                        help='disable test generation by mutation (disabled by default if no population is given).')
    parser.add_argument('--no-recombine', dest='recombine', default=True, action='store_false',
                        help='disable test generation by recombination (disabled by default if no population is given).')
    parser.add_argument('--keep-trees', action='store_true',
                        help='keep generated tests to participate in further mutations or recombinations (only if population is given).')
    add_tree_format_argument(parser)
    add_iteration_arguments(parser)

    # Auxiliary settings.
    parser.add_argument('--clean-gen', action="store_true", help="remove all previously generated tests in ./target/tests folder.")
    parser.add_argument('-o', '--out', metavar='FILE', default=join(target_loc, 'tests', 'test_%d'),
                        help='output file name pattern (default: %(default)s).')
    parser.add_argument('--stdout', dest='out', action='store_const', const='', default=SUPPRESS,
                        help='print test cases to stdout (alias for --out=%(const)r)')
    parser.add_argument('-n', default=1, type=int, metavar='NUM',
                        help='number of tests to generate, \'inf\' for continuous generation (default: %(default)s).')
    parser.add_argument('--random-seed', type=int, metavar='NUM',
                        help='initialize random number generator with fixed seed (not set by default).')
    parser.add_argument('--dry-run', action='store_true',
                        help='generate tests without writing them to file or printing to stdout (do not keep generated tests in population either)')
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
        reset_trace()

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

    # had to disable multi-thread if we need to constantly update trace.json
    # since this style won't work with multi-thread
    args.jobs = 0

    if args.iterative:
        iter = stale_iter = 0
        cur_coverage = pre_coverage = 0

        max_stale_iter = args.max_stale_iter if args.max_stale_iter else 10
        while cur_coverage < args.coverage_goal and stale_iter < max_stale_iter:
            args.out = f'{folders}iter_{iter}_{filename}'
            if args.jobs > 1:
                with Manager() as manager:
                    with generator_tool_helper(args, weights=manager.dict(get_weights(args, pre_coverage, cur_coverage)), lock=manager.Lock()) as generator_tool:  # pylint: disable=no-member
                        parallel_create_test = partial(create_test, generator_tool, seed=args.random_seed)
                        with Pool(args.jobs) as pool:
                            for _ in pool.imap_unordered(parallel_create_test, count(0) if args.n == inf else range(args.n)):
                                pass

            else:
                with generator_tool_helper(args, weights=get_weights(args, pre_coverage, cur_coverage), lock=None) as generator_tool:
                    for i in count(0) if args.n == inf else range(args.n):
                        create_test(generator_tool, i, seed=args.random_seed)
            pre_coverage = cur_coverage
            try:
                file_list = glob.glob(f'{folders}iter_{iter}_*')
                print(f"Executing {file_path} with the {len(file_list)} files generated during iter {iter}.")
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
            print(f'After iter {iter}, overall coverage is {cur_coverage:.2f}%.\n')
            if cur_coverage == pre_coverage:
                stale_iter += 1
            else:
                stale_iter = 0
            iter += 1
        cov.stop()
        if args.ignore_final_report:
            cov.report(show_missing=True, file=dump)
        else:
            cov.report(show_missing=True)
    else:
        args.out = f'{folders}_{filename}'
        if args.jobs > 1:
            with Manager() as manager:
                with generator_tool_helper(args, weights=manager.dict(get_weights(args, 0, 0)), lock=manager.Lock()) as generator_tool:  # pylint: disable=no-member
                    parallel_create_test = partial(create_test, generator_tool, seed=args.random_seed)
                    with Pool(args.jobs) as pool:
                        for _ in pool.imap_unordered(parallel_create_test, count(0) if args.n == inf else range(args.n)):
                            pass
        else:
            with generator_tool_helper(args, weights=get_weights(args, 0, 0), lock=None) as generator_tool:
                for i in count(0) if args.n == inf else range(args.n):
                    create_test(generator_tool, i, seed=args.random_seed)
        try:
            file_list = glob.glob(f'{folders}*')
            print(f"Executing {file_path} with the {len(file_list)} generated files.")
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
        cov.stop()
        if args.ignore_final_report:
            cov.report(show_missing=True, file=dump)
        else:
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
