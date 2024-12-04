# First step

in root folder, run

`pip install .`

and

`grammarinator-process html.g4`

# Base Case(no iteration)

in root folder, run

`grammarinator-generate htmlGenerator.htmlGenerator -r html --start-filename generate_pdf.py --clean-gen --stmt-cov -d 12 -n 1`

# Iterative coverage increase

in root folder, run

`grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation --iterative --start-filename calculator.py --coverage-goal 91 -n 2 -d 10 --clean-gen`
