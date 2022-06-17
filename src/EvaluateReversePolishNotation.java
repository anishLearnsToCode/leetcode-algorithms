// https://leetcode.com/problems/evaluate-reverse-polish-notation
// T: O(N)
// S: O(N)

import java.util.Set;
import java.util.Stack;

public class EvaluateReversePolishNotation {
    private static final String ADDITION = "+";
    private static final String SUBTRACTION = "-";
    private static final String MULTIPLICATION = "*";
    private static final String DIVISION = "/";

    private static final Set<String> OPERATORS = Set.of(
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION,
        DIVISION
    );

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                int number1 = stack.pop();
                int number2 = stack.pop();
                stack.push(apply(number2, number1, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private static int apply(int a, int b, String operator) {
        return switch (operator) {
            case ADDITION -> a + b;
            case SUBTRACTION -> a - b;
            case MULTIPLICATION -> a * b;
            case DIVISION -> a / b;
            default -> 0;
        };
    }
}
