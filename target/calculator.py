import glob
import os
import math
import sys
from calcClass import Calculator

def main(equation):
    calc = Calculator()
    if equation:
        equation = equation.replace('^', '**')
        print(f"Evaluating: {equation}")
        try:
            result = calc.evaluate(equation)
            assert math.isclose(result, eval(equation), rel_tol=1e-9, abs_tol=1e-9)
            print("Result:", result, '\n')
        except Exception as e:
            print(f'error: {e}')
            
if len(sys.argv) > 1:
    print(f'received {sys.argv}')
    equation = sys.argv[1]
    main(equation)