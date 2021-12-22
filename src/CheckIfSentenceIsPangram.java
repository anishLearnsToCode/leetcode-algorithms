// https://leetcode.com/problems/check-if-the-sentence-is-pangram
// T: O(|s|)
// S: O(1)

import java.util.HashSet;
import java.util.Set;

public class CheckIfSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        final Set<Character> letters = getLetters(sentence);
        return letters.size() == 26;
    }

    private Set<Character> getLetters(String s) {
        final Set<Character> letters = new HashSet<>();
        for (int index = 0 ; index < s.length() ; index++) {
            letters.add(s.charAt(index));
        }
        return letters;
    }
}
