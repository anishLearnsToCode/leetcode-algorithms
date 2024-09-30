// https://leetcode.com/problems/palindrome-permutation
// T: O(|s|)
// S: O(|s|)

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        final Map<Character, Integer> frequencies = getCharacterFrequencies(s);
        return getNumberOfOddChars(frequencies) <= 1;
    }

    private static Map<Character, Integer> getCharacterFrequencies(String string) {
        final Map<Character, Integer> result = new HashMap<>();
        for (int i = 0 ; i < string.length() ; i++) {
            final char c = string.charAt(i);
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }

    private static int getNumberOfOddChars(Map<Character, Integer> frequencies) {
        int result = 0;
        for (int freq : frequencies.values()) {
            if (freq % 2 == 1) {
                result++;
            }
        }
        return result;
    }
}
