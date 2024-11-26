# First step

in root folder, run

`pip install .`

and

`grammarinator-process calculator.g4`

# Base Case(no iteration)

in root folder, run

`grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation -d 12 -o ./calculator/tests/test_%d.txt -n 100 --sys-path ./calculator`

then run

`coverage run ./target/calculator.py`

then run

`coverage report -m`

# Iterative coverage increase

in root folder, run

`grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation --sys-path ./target --iterative --coverage-goal 91 --start-filename calculator.py -n 10 -d 10`
