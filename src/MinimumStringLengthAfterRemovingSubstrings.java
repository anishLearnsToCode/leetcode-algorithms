// https://leetcode.com/problems/minimum-string-length-after-removing-substrings
// T: O(N)
// S: O(N)

import java.util.Set;
import java.util.Stack;

public class MinimumStringLengthAfterRemovingSubstrings {
    final static Set<Character> REMOVAL_TERMINATING_CHARS = Set.of('B', 'D');

    public int minLength(String s) {
        final Stack<Character> stack = new Stack<>();
        for (int i = 0 ; i < s.length() ; i++) {
            final char letter = s.charAt(i);
            if (!stack.isEmpty() && REMOVAL_TERMINATING_CHARS.contains(letter) && stack.peek() == inverse(letter)) {
                stack.pop();
            } else {
                stack.push(letter);
            }
        }
        return stack.size();
    }

    private char inverse(char letter) {
        return switch (letter) {
            case 'B' -> 'A';
            case 'D' -> 'C';
            default -> ' ';
        };
    }
}
