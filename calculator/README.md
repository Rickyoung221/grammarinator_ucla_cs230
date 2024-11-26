# First step

in root folder, run

`pip install .`

and

`grammarinator-process ./calculator/calculator.g4 -o ./calculator/`

# Base Case(no iteration)

in root folder, run

`grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation -d 12 -o ./calculator/tests/test_%d.txt -n 100 --sys-path ./calculator`

then run

`coverage run ./calculator/calculator.py`

then run

`coverage report -m`

# Iterative coverage increase

in root folder, run

`grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation -o ./calculator/tests/test_%d.txt --sys-path ./calculator --iterative --coverage-goal 91 -n 10 -d 10`
