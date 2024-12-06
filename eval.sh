cat /dev/null > target/iter_counts.csv
echo "unweighted,neg_temp,pos_temp" >> target/iter_counts.csv
for i in {1..100}
do
    UNWEIGHTED_ITER=$(grammarinator-generate TexasHoldemGenerator.TexasHoldemGenerator -r game --iterative --start-filename texas.py --clean-gen --coverage-goal 97.5 --max-stale-iter 100 -d 10 -n 2 -ifr | tail -n 2 | grep 'iter' | awk '{print $3}' | sed 's/.$//' )
    NEG_SOFTMAX_ITER=$(grammarinator-generate TexasHoldemGenerator.TexasHoldemGenerator -r game --iterative --start-filename texas.py --clean-gen --coverage-goal 97.5 --max-stale-iter 100 -d 10 -n 2 --weighted-gen -ifr | tail -n 2 | grep 'iter' | awk '{print $3}' | sed 's/.$//' )
    POS_SOFTMAX_ITER=$(grammarinator-generate TexasHoldemGenerator.TexasHoldemGenerator -r game --iterative --start-filename texas.py --clean-gen --coverage-goal 97.5 --max-stale-iter 100 -d 10 -n 2 --weighted-gen -pts -ifr | tail -n 2 | grep 'iter' | awk '{print $3}' | sed 's/.$//' )

    echo "$UNWEIGHTED_ITER,$NEG_SOFTMAX_ITER,$POS_SOFTMAX_ITER" >> target/iter_counts.csv
done

python eval.py