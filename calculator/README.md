in root folder, first run

`grammarinator-process .\calculator\calculator.g4 -o .\calculator\`

then run

`grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation -d 12 -o ./calculator/tests/test_%d.txt -n 100 --sys-path Calculator/`

then install if you don't have coverage

`pip install coverage`

then run

`coverage run .\calculator\calculator.py`

then run

`coverage report -m`
