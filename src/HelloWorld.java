import java.util.Set;
import java.util.Stack;

public class HelloWorld {
    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");

    public int evalRPN(String[] tokens) {
        final Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                final int second = stack.pop();
                final int first = stack.pop();
                final int result = apply(token, first, second);
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }

    private static boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private static int apply(String operator, int first, int second) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "/" -> first / second;
            case "*" -> first * second;
            default -> 0;
        };
    }
}
