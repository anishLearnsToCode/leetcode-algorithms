// https://leetcode.com/problems/maximum-number-of-words-you-can-type
// T: O(|brokenLetters| + |text|)
// S: O(1)

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberOfWordsYouCanType {
    public int canBeTypedWords(String text, String brokenLetters) {
        final Set<Character> brokenCharacters = getCharacters(brokenLetters);
        int words = 0;
        boolean canType = true;
        for (int i = 0 ; i < text.length() ; i++) {
            if (text.charAt(i) == ' ') {
                if (canType) words++;
                canType = true;
            } else if (brokenCharacters.contains(text.charAt(i))) {
                canType = false;
            }
        }
        return words + (canType ? 1 : 0);
    }

    private Set<Character> getCharacters(String s) {
        final Set<Character> set = new HashSet<>();
        for (int i = 0 ; i < s.length() ; i++) {
            set.add(s.charAt(i));
        }
        return set;
    }
}
