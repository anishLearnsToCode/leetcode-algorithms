// https://leetcode.com/problems/count-the-number-of-special-characters-i
// T: O(N)
// S: O(1)

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfSpecialCharactersI {
    public int numberOfSpecialChars(String word) {
        final Set<Character> characters = new HashSet<>();
        final Set<Character> alreadyCounted = new HashSet<>();
        int specialChars = 0;

        for (int i = 0 ; i < word.length() ; i++) {
            characters.add(word.charAt(i));
            if (characters.contains(inverse(word.charAt(i))) && !alreadyCounted.contains(word.charAt(i))) {
                specialChars++;
                alreadyCounted.add(word.charAt(i));
                alreadyCounted.add(inverse(word.charAt(i)));
            }
        }

        return specialChars;
    }

    private static char inverse(char c) {
        if (Character.isLowerCase(c)) {
            return Character.toUpperCase(c);
        }
        return Character.toLowerCase(c);
    }
}
