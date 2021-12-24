// https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence
// T: O(|s|)
// S: O(|s|)

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfNumbersAreAscendingInASentence {
    public boolean areNumbersAscending(String s) {
        StringBuilder word = new StringBuilder();
        final Queue<String> numbers = new LinkedList<>();
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == ' ') {
                if (isNumber(word)) {
                    if (!numbers.isEmpty() && lessThanEqual(word.toString(), numbers.peek())) {
                        return false;
                    }
                    numbers.poll();
                    numbers.add(word.toString());
                }
                word = new StringBuilder();
            } else word.append(s.charAt(i));
        }
        return !isNumber(word) || numbers.isEmpty() || !lessThanEqual(word.toString(), numbers.peek());
    }

    private boolean isNumber(StringBuilder s) {
        return Character.isDigit(s.charAt(0));
    }

    private boolean lessThanEqual(String s, String o) {
        if (s.length() < o.length()) return true;
        if (s.length() > o.length()) return false;
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) < o.charAt(i)) return true;
            if (s.charAt(i) > o.charAt(i)) return false;
        }
        return true;
    }
}
