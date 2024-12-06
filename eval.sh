# for loop
cat /dev/null > target/iter_trace.csv
for i in {1..10}
do
    WEIGHTED_ITER=$(grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation --iterative --start-filename calculator.py --clean-gen --stmt-cov --coverage-goal 96 --max-stale-iter 100 -d 11 -n 5 --weighted-gen | tail -n 2 | grep 'iter' | awk '{print $3}' | sed 's/.$//' )
    ITER=$(grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation --iterative --start-filename calculator.py --clean-gen --stmt-cov --coverage-goal 96 --max-stale-iter 100 -d 11 -n 5 | tail -n 2 | grep 'iter' | awk '{print $3}' | sed 's/.$//' )

    echo "$WEIGHTED_ITER, $ITER" >> target/iter_trace.csv
done