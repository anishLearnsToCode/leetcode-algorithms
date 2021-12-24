// https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent
// T: O(|word1| + |word2|)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class CheckWhetherTwoStringsAreAlmostEquivalent {
    public boolean checkAlmostEquivalent(String word1, String word2) {
        final Map<Character, Integer> word1Frequencies = getFrequencies(word1);
        final Map<Character, Integer> word2Frequencies = getFrequencies(word2);
        for (char c = 'a' ; c <= 'z' ; c++) {
            if (Math.abs(word1Frequencies.getOrDefault(c, 0) - word2Frequencies.getOrDefault(c, 0))
                    > 3) {
                return false;
            }
        }
        return true;
    }

    private Map<Character, Integer> getFrequencies(String s) {
        final Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++) {
            frequencies.put(s.charAt(i), frequencies.getOrDefault(s.charAt(i), 0) + 1);
        }
        return frequencies;
    }
}
