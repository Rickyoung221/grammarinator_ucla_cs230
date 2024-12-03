# First step

in root folder, run

`pip install .`

and

`grammarinator-process calculator.g4`

# Base Case(no iteration)

in root folder, run

`grammarinator-generate CalculatorGenerator.CalculatorGenerator --start-filename calculator.py -r equation -d 12 -n 100`

then run

`coverage run ./target/calculator.py`

then run

`coverage report -m`

# Iterative coverage increase

in root folder, run

`grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation --iterative --start-filename calculator.py -d 10 --clean-gen --max-stale-iter 2 --stmt-cov --coverage-goal 91 -n 2`
