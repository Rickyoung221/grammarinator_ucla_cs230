# Copyright (c) 2020-2024 Renata Hodovan, Akos Kiss.
#
# Licensed under the BSD 3-Clause License
# <LICENSE.rst or https://opensource.org/licenses/BSD-3-Clause>.
# This file may not be copied, modified, or distributed except
# according to those terms.

import glob
import logging
import os

from inators.imp import import_object

from .tool import FlatBuffersTreeCodec, JsonTreeCodec, PickleTreeCodec
from argparse import ArgumentParser
from os.path import exists

logger = logging.getLogger('grammarinator')


def init_logging():
    logging.basicConfig(format='%(message)s')


def import_list(lst):
    return [import_object(item) for item in lst]


def add_jobs_argument(parser: ArgumentParser):
    parser.add_argument('-j', '--jobs', metavar='NUM', type=int, default=os.cpu_count(),
                        help='parallelization level (default: number of cpu cores (%(default)d)).')


def add_disable_cleanup_argument(parser: ArgumentParser):
    parser.add_argument('--disable-cleanup', dest='cleanup', default=True, action='store_false',
                        help='disable the removal of intermediate files.')


def add_encoding_argument(parser: ArgumentParser, help):
    parser.add_argument('--encoding', metavar='NAME', default='utf-8',
                        help=help)


def add_encoding_errors_argument(parser: ArgumentParser):
    parser.add_argument('--encoding-errors', metavar='NAME', default='strict',
                        help='encoding error handling scheme (default: %(default)s).')


tree_formats = {
    'pickle': {'extension': 'grtp', 'codec_class': PickleTreeCodec},
    'json': {'extension': 'grtj', 'codec_class': JsonTreeCodec},
    'flatbuffers': {'extension': 'grtf', 'codec_class': FlatBuffersTreeCodec},
}


def add_tree_format_argument(parser: ArgumentParser):
    parser.add_argument('--tree-format', metavar='NAME', choices=sorted(tree_formats.keys()), default='pickle',
                        help='format of the saved trees (choices: %(choices)s, default: %(default)s)')
    
def add_iteration_arguments(parser: ArgumentParser):
    parser.add_argument('--iterative', action='store_true', help="Enable iterative mode. The number of test cases generated per iteration will be the same as -n.")
    parser.add_argument('--coverage-goal', type=float, metavar='FLOAT', help='The target code coverage. Need to give a positive number between 0 and 100.')
    parser.add_argument('--start-filename', type=str, help='The filename of the starting python file for the program located within ./target folder.')
    parser.add_argument('--stmt-cov', action="store_true", help='Enable statement coverage mode.')
    parser.add_argument('--max-stale-iter', type=int, help="The maximum stale iteration allowed. Default 10. Between 1 and 100.")
    parser.add_argument('-ifr', '--ignore-final-report', action='store_true', help='Ignore the final coverage report such that the shell script can caputre the iteration count.')
    parser.add_argument('-pts', '--positive-temp-softmax', action='store_true', help='Use positive-temp-softmax instead of negative-temp-softmax. Need to enable --weighted-gen.')
    parser.add_argument('--show-trace', action='store_true', help="Show the trace and temperature at each iteration.")

def validate_iteration_arguments(args, target_loc):
    if not args.iterative: return
    if args.coverage_goal is None:
        raise ValueError("--coverage-goal is required when --iterative is provided.")
    if (args.coverage_goal <= 0 or args.coverage_goal > 100):
        raise ValueError("--coverage-goal must be a positive number less than or equal to 100.")
    if not args.start_filename:
        raise ValueError('--start-filename must be provided when --iterative is provided.')
    if not exists(target_loc+args.start_filename):
        raise ValueError(f"{args.start_filename} doesn't exist in {target_loc}")
    if args.max_stale_iter is not None and (args.max_stale_iter <= 0 or args.max_stale_iter > 100):
        raise ValueError('if provided, --max-stale-iter must be a positive number less than or equal to 100.')

def process_tree_format_argument(args):
    tree_format = tree_formats[args.tree_format]
    args.tree_extension = tree_format['extension']
    args.tree_codec = tree_format['codec_class']()


def iter_files(args):
    for fn in args.input or []:
        if os.path.isdir(fn):
            for dirpath, _, filenames in os.walk(fn):
                for f in filenames:
                    yield os.path.join(dirpath, f)
        else:
            yield fn

    for pattern in args.glob or []:
        yield from glob.glob(pattern)
