import java.util.Stack;

class BasicCalculator {
    public int calculate(String s) {
        final Stack<Integer> stack = new Stack<Integer>();
        int number = 0;
        int result = 0; // For the ongoing result
        int sign = 1;  // 1 means positive, -1 means negative

        for (int i = 0; i < s.length(); i++) {
            final char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = 10 * number + (ch - '0');
            } else if (isOperator(ch)) {
                result += sign * number;
                number = 0;
                sign = ch == '+' ? 1 : -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            } else if (ch == ')') {
                result += sign * number;
                result *= stack.pop();
                result += stack.pop();
                number = 0;
            }
        }

        return result + (sign * number);
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-';
    }
}