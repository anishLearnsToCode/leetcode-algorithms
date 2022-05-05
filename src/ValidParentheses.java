// https://leetcode.com/problems/valid-parentheses/
// T: O(n)
// S: O(n)

import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    private static final Set<Character> CLOSING_BRACES = Set.of(')', ']', '}');

    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
        char bracket;
        for (int i = 0 ; i < s.length() ; i++) {
            bracket = s.charAt(i);
            if (isClosingBracket(bracket)) {
                if (!stack.isEmpty() && areOpposites(stack.peek(), bracket)) {
                    stack.pop();
                } else return false;
            } else stack.push(bracket);
        }
        return stack.isEmpty();
    }

    private boolean isClosingBracket(char c) {
        return CLOSING_BRACES.contains(c);
    }

    private boolean areOpposites(char left, char right) {
        return switch(left) {
            case '(' -> right == ')';
            case '[' -> right == ']';
            case '{' -> right == '}';
            default -> false;
        };
    }
}
