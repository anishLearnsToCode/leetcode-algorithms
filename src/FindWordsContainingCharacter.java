// https://leetcode.com/problems/find-words-containing-character
// T: O(|words| * |words[i].length|)
// S: O(1)

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {
    public List<Integer> findWordsContaining(String[] words, char x) {
        final List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < words.length ; i++) {
            if (containsCharacter(words[i], x)) {
                result.add(i);
            }
        }

        return result;
    }

    private static boolean containsCharacter(String s, char c) {
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == c) {
                return true;
            }
        }
        return false;
    }
}
