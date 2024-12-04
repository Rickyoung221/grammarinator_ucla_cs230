# First step

in root folder, run

`pip install .`

then go to `./target/xhtml2pdf` and run

`pip install -e .`

then go back to root folder and run

`grammarinator-process html.g4`

# Base Case(no iteration)

in root folder, run

`grammarinator-generate htmlGenerator.htmlGenerator -r html --start-filename generate_pdf.py --clean-gen --stmt-cov -d 12 -n 1`

# Iterative coverage increase

in root folder, run

`grammarinator-generate htmlGenerator.htmlGenerator -r html --iterative --start-filename generate_pdf.py --coverage-goal 91 -n 2 -d 10 --clean-gen`
