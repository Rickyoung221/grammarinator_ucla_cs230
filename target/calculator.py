import ast
import glob
import operator
import os

# Define supported operators
operators = {
    ast.Add: operator.add,
    ast.Sub: operator.sub,
    ast.Mult: operator.mul,
    ast.Div: operator.truediv,
    ast.Pow: operator.pow,
    ast.USub: operator.neg,
    ast.Mod: operator.mod
}

class Calculator:
    def evaluate(self, expression: str) -> float:
        """
        Evaluates a mathematical expression string safely.

        Parameters:
            expression (str): A mathematical expression, e.g., "3 + (2 / 5)"

        Returns:
            float: The result of the evaluated expression.
        """
        try:
            # Parse the expression into an Abstract Syntax Tree (AST)
            parsed_expr = ast.parse(expression, mode='eval').body
            return self._evaluate_ast(parsed_expr)
        except ZeroDivisionError:
            print("Error: Division by zero is not allowed.")
            raise ValueError()
        except (SyntaxError, ValueError) as e:
            print(f"Invalid expression: {expression}, Error: {str(e)}")
            raise ValueError()

    def _evaluate_ast(self, node) -> float:
        """
        Recursively evaluates an AST node.

        Parameters:
            node: The root node of the AST to evaluate.

        Returns:
            float: The evaluated result of the AST node.
        """
        if isinstance(node, ast.Constant):  # For Python 3.8 and above
            return node.value
        elif isinstance(node, ast.BinOp):
            left = self._evaluate_ast(node.left)
            right = self._evaluate_ast(node.right)
            op_type = type(node.op)
            if op_type in operators:
                # Ensure exponentiation handles float values
                if op_type is ast.Pow:
                    try:
                        return operators[op_type](float(left), float(right))
                    except OverflowError as e:
                        print(f"Error: {e}")
                        raise ValueError()
                try:
                    return operators[op_type](left, right)
                except TypeError as e:
                    print(f"Error: {e}")
                    raise ValueError()
            else:
                raise ValueError("Unsupported operation")
        elif isinstance(node, ast.UnaryOp) and isinstance(node.op, ast.USub):
            operand = self._evaluate_ast(node.operand)
            return operators[ast.USub](operand)
        else:
            raise ValueError("Unsupported operation or node")

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