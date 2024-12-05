rm target/tests/*
for i in {1..3}
do
    grammarinator-generate CalculatorGenerator.CalculatorGenerator --start-filename calculator.py -r equation --iterative --start-filename calculator.py -d 9 --stmt-cov --coverage-goal 91 -n 1 --jobs 1 --fix-iter 1
done