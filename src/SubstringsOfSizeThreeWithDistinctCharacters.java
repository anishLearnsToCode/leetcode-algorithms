// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters
// T: O(N)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class SubstringsOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
        if (s.length() < 3) return 0;
        final Map<Character, Integer> frequency = getFrequency(s, 3);
        int goodSubStrings = 0;
        if (frequency.size() == 3) goodSubStrings++;
        for (int index = 3 ; index < s.length() ; index++) {
            remove(frequency, s.charAt(index - 3));
            frequency.put(s.charAt(index), frequency.getOrDefault(s.charAt(index), 0) + 1);
            if (frequency.size() == 3) goodSubStrings++;
        }
        return goodSubStrings;
    }

    private Map<Character, Integer> getFrequency(String s, int upto) {
        final Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0 ; i < upto ; i++) {
            frequencies.put(s.charAt(i), frequencies.getOrDefault(s.charAt(i), 0) + 1);
        }
        return frequencies;
    }

    private void remove(Map<Character, Integer> frequencies, char c) {
        if (frequencies.get(c) == 1) frequencies.remove(c);
        else frequencies.put(c, frequencies.get(c) - 1);
    }
}
