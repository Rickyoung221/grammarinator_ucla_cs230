# First step

in root folder, run

`pip install .`

and

`grammarinator-process texasHoldem.g4`

# Base Case(no iteration)

in root folder, run

`grammarinator-generate TexasHoldemGenerator.TexasHoldemGenerator -r game -d 12 -n 100`

then run

`coverage run ./target/texas.py`

then run

`coverage report -m`

# Iterative coverage increase

in root folder, run

`grammarinator-generate TexasHoldemGenerator.TexasHoldemGenerator -r game --iterative --start-filename texas.py -d 10 --clean-gen --max-stale-iter 2--coverage-goal 96 -n 2`
