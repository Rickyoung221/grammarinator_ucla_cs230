# First step

in root folder, run

`pip install .`

and

`grammarinator-process texasHoldem.g4`

# Base Case(no iteration)

in root folder, run
`grammarinator-generate TexasHoldemGenerator.TexasHoldemGenerator -r game --start-filename texas.py --clean-gen -d 10 -n 100`

# Iterative coverage increase

in root folder, run

`grammarinator-generate TexasHoldemGenerator.TexasHoldemGenerator -r game --iterative --start-filename texas.py --clean-gen --coverage-goal 97.5 --max-stale-iter 100 -d 10 -n 2 --weighted-gen`

# Other commands

`-pts: --positive-temp-softmax`

`--show-trace`

`-ifr: --ignore-final-report`
