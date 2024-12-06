cat /dev/null > target/iter_counts.csv
echo "unweighted, neg_temp, pos_temp" >> target/iter_counts.csv
for i in {1..100}
do
    UNWEIGHTED_ITER=$(grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation --iterative --start-filename calculator.py --clean-gen --stmt-cov --coverage-goal 96 --max-stale-iter 100 -d 11 -n 5 -ifr | tail -n 2 | grep 'iter' | awk '{print $3}' | sed 's/.$//' )
    NEG_SOFTMAX_ITER=$(grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation --iterative --start-filename calculator.py --clean-gen --stmt-cov --coverage-goal 96 --max-stale-iter 100 -d 11 -n 5 --weighted-gen -ifr | tail -n 2 | grep 'iter' | awk '{print $3}' | sed 's/.$//' )
    POS_SOFTMAX_ITER=$(grammarinator-generate CalculatorGenerator.CalculatorGenerator -r equation --iterative --start-filename calculator.py --clean-gen --stmt-cov --coverage-goal 96 --max-stale-iter 100 -d 11 -n 5 --weighted-gen -pts -ifr | tail -n 2 | grep 'iter' | awk '{print $3}' | sed 's/.$//' )

    echo "$UNWEIGHTED_ITER, $NEG_SOFTMAX_ITER, $POS_SOFTMAX_ITER" >> target/iter_counts.csv
done

python eval.py