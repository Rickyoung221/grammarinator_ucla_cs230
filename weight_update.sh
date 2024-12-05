echo "{}" > target/trace.json
grammarinator-generate CalculatorGenerator.CalculatorGenerator --start-filename calculator.py -r equation --iterative --start-filename calculator.py -d 9 --clean-gen --stmt-cov --coverage-goal 91 -n 1 --jobs 1 -w target/trace.json -u --fix-iter 1

python grammarinator/weight_update.py

grammarinator-generate CalculatorGenerator.CalculatorGenerator --start-filename calculator.py -r equation --iterative --start-filename calculator.py -d 9 --stmt-cov --coverage-goal 91 -n 1 --jobs 1 -w target/trace.json -u --fix-iter 1

python grammarinator/weight_update.py

grammarinator-generate CalculatorGenerator.CalculatorGenerator --start-filename calculator.py -r equation --iterative --start-filename calculator.py -d 9 --stmt-cov --coverage-goal 91 -n 1 --jobs 1 -w target/trace.json -u --fix-iter 1
