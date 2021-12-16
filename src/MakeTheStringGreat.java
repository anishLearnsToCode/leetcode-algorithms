// https://leetcode.com/problems/make-the-string-great
// T: O(N)
// S: O(N)

import java.util.Stack;

public class MakeTheStringGreat {
    public String makeGood(String s) {
        final Stack<Character> characters = new Stack<>();
        for (int index = 0 ; index < s.length() ; index++) {
            char c = s.charAt(index);
            if (!characters.isEmpty() && c == inverse(characters.peek())) {
                characters.pop();
            } else characters.push(c);
        }
        return toStringBuilder(characters).reverse().toString();
    }

    private StringBuilder toStringBuilder(Stack<Character> stack) {
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) result.append(stack.pop());
        return result;
    }

    private char inverse(char c) {
        return Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c);
    }
}
