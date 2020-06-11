// https://leetcode.com/problems/valid-parentheses/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class ValidParentheses {
    private static final Set<Character> openBrackets = new HashSet<>();
    private static final Map<Character, Character> inverse = new HashMap<>();

    static {
        openBrackets.add('(');
        openBrackets.add('{');
        openBrackets.add('[');

        inverse.put(')', '(');
        inverse.put('}', '{');
        inverse.put(']', '[');
    }

    public boolean isValid(String string) {
        Stack<Character> brackets = new Stack<>();
        for(int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            if (isOpenBracket(character)) {
                brackets.push(character);
            } else {
                if (!brackets.isEmpty() && brackets.peek() == inverse(character)) {
                    brackets.pop();
                } else {
                    return false;
                }
            }
        }

        return brackets.isEmpty();
    }

    private char inverse(char bracket) {
        return inverse.get(bracket);
    }

    private boolean isOpenBracket(char bracket) {
        return openBrackets.contains(bracket);
    }
}
