import ast
import operator


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
            parsed_expr = ast.parse(expression, mode='eval').body
            return self._evaluate_ast(parsed_expr)
        except ZeroDivisionError:
            print("Error: Division by zero is not allowed.")
            raise ValueError("Division by zero is not allowed.")
        except (SyntaxError, ValueError) as e:
            print(f"Invalid expression: {expression}, Error: {str(e)}")
            raise ValueError("Invalid expression")

    def _evaluate_ast(self, node) -> float:
        if isinstance(node, ast.Constant):
            return node.value
        elif isinstance(node, ast.BinOp):
            return self._evaluate_binop(node)
        elif isinstance(node, ast.UnaryOp):
            return self._evaluate_unaryop(node)
        else:
            raise ValueError("Unsupported node type")

    def _evaluate_binop(self, node):
        left = self._evaluate_ast(node.left)
        right = self._evaluate_ast(node.right)
        operation = {
            ast.Add: self._add,
            ast.Sub: self._subtract,
            ast.Mult: self._multiply,
            ast.Div: self._divide,
            ast.Pow: self._power,
            ast.Mod: self._modulus
        }.get(type(node.op), self._unsupported_operation)
        return operation(left, right)

    def _evaluate_unaryop(self, node):
        if isinstance(node.op, ast.USub):
            operand = self._evaluate_ast(node.operand)
            return self._negate(operand)
        else:
            raise ValueError("Unsupported unary operation")

    def _add(self, left, right):
        return left + right

    def _subtract(self, left, right):
        return left - right

    def _multiply(self, left, right):
        return left * right

    def _divide(self, left, right):
        return left / right

    def _power(self, left, right):
        return pow(left, right)

    def _modulus(self, left, right):
        return left % right

    def _negate(self, value):
        return -value

    def _unsupported_operation(self, *args):
        raise ValueError("Unsupported operation")