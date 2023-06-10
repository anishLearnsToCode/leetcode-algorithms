// https://leetcode.com/problems/count-the-number-of-vowel-strings-in-range
// T: O(N)
// S: O(1)

import java.util.Set;

public class CountTheNumberOfVowelStringsInRange {
    private final static Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

    public int vowelStrings(String[] words, int left, int right) {
        int vowelStrings = 0;
        for (int i = left ; i <= right ; i++) {
            if (isVowelString(words[i])) {
                vowelStrings++;
            }
        }
        return vowelStrings;
    }

    private boolean isVowelString(String word) {
        return isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private boolean isVowel(char c) {
        return VOWELS.contains(c);
    }
}
