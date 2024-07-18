// https://leetcode.com/problems/valid-word
// T: O(N)
// S: O(1)

import java.util.Set;

public class ValidWord {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean isValid(String word) {
        return word.length() >= 3 && isAlphaNum(word) && hasOneVowel(word) && hasOneConsonant(word);
    }

    private static boolean isAlphaNum(String s) {
        for (int i = 0 ; i < s.length() ; i++) {
            if (!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasOneVowel(String s) {
        for (int i = 0 ; i < s.length() ; i++) {
            if (VOWELS.contains(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static boolean hasOneConsonant(String s) {
        for (int i = 0 ; i < s.length() ; i++) {
            if (Character.isAlphabetic(s.charAt(i)) && !VOWELS.contains(s.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
