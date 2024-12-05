# Copyright (c) 2020-2023 Renata Hodovan, Akos Kiss.
#
# Licensed under the BSD 3-Clause License
# <LICENSE.rst or https://opensource.org/licenses/BSD-3-Clause>.
# This file may not be copied, modified, or distributed except
# according to those terms.

import random
import json
import os
from .model import Model


class DefaultModel(Model):
    """
    Default decision model implementation.
    """
    
    def __init__(self):
        self.trace = {}

    def choice(self, node, idx, weights):
        """
        The decision is solely based upon the provided ``weights``.

        Parameters ``node`` and ``idx`` are unused.
        """
        # assert sum(weights) > 0, 'Sum of weights is zero.'
        self.read_trace()
        print(weights)
        choice = random.choices(range(len(weights)), weights=weights)[0]
        #if trace has this node, divide the weight by half
        choice_str = str(choice)
        if node.name not in self.trace:
            self.trace[node.name] = {}
            self.trace[node.name]["0"] = {}
        if choice_str not in self.trace[node.name]["0"]:
            self.trace[node.name]["0"][choice_str] = 0
        self.trace[node.name]["0"][choice_str] += 1
        self.save_trace()
        return choice

    def quantify(self, node, idx, cnt, start, stop):
        """
        After generating the minimum expected items (``start``) and before
        reaching the maximum expected items (``stop``), quantify decides about
        the expansion of the optional items based on a random binary decision.

        Parameters ``node``, ``idx``, ``cnt``, ``start``, and ``stop`` are
        unused.
        """
        return bool(random.getrandbits(1))

    def charset(self, node, idx, chars):
        """
        A single character is chosen randomly from the set of possible options
        (``chars``).

        Parameters ``node`` and ``idx`` are unused.
        """
        return chr(random.choice(chars))
    def read_trace(self):
        """
        Reads the trace dictionary.
        Ensures that the file is closed properly and the operation completes before proceeding.
        """
        try:
            with open("target/trace.json", 'r') as f:
                self.trace = json.load(f)
        except FileNotFoundError:
            # Handle case where trace file does not exist
            self.trace = {}
        except json.JSONDecodeError:
            # Handle case where the trace file is corrupted or improperly formatted
            self.trace = {}

    def save_trace(self):
        """
        Saves the trace dictionary as a JSON file.
        Ensures the operation completes before proceeding.
        """
        with open("target/trace.json", 'w') as f:
            json.dump(self.trace, f, indent=4)
            f.flush()  # Flush the internal buffer to the OS buffer
            os.fsync(f.fileno())  # Flush the OS buffer to the disk