import glob
import os
from calcClass import Calculator

def main():
    calc = Calculator()

    folder_path = './target/tests/'  # Replace with your folder path

    # Enumerate all files in target test folder
    for file_path in glob.glob(os.path.join(folder_path,'*')):
        with open(file_path, 'r') as file:
            expression = file.read().strip()  # Read and strip whitespace/newlines
            # Replace '^' with '**' for exponentiation
            expression = expression.replace('^', '**')
            print(f"Evaluating expression in {file_path}: {expression}")
            result = None
            try:
                result = calc.evaluate(expression)
                assert result == eval(expression)
            except ValueError:
                pass
            print("Result:", result, '\n')

main()