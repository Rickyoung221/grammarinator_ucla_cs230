# First step

in root folder, run

`pip install .`

and

`grammarinator-process calculator.g4`

# Base Case(no iteration)

in root folder, run

`grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation --start-filename calculator.py --clean-gen -d 12 -n 100`

# Iterative coverage increase

in root folder, run

`grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation --iterative --start-filename calculator.py --clean-gen --stmt-cov --coverage-goal 96 --max-stale-iter 100 -d 11 -n 5 --weighted-gen`

# Other commands

`-pts: --positive-temp-softmax`

`--show-trace`

`-ifr: --ignore-final-report`
