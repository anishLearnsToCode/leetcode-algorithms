// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i
// T: O(|word|)
// S: O(|word|)

import java.util.HashMap;
import java.util.Map;

public class MinimumNumberOfPushesToTypeWordI {
    public static int minimumPushes(String word) {
        final Map<Character, Integer> letterFrequency = getLetterFrequencies(word);
        final var entries = letterFrequency.entrySet().stream().sorted((a, b) -> Integer.compare(b.getValue(), a.getValue())).toList();

        int pushes = 0;
        for (int i = 0 ; i < entries.size() ; i++) {
            pushes += entries.get(i).getValue() * ((i + 8) / 8);
        }

        return pushes;
    }

    private static Map<Character, Integer> getLetterFrequencies(String s) {
        final Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++) {
            frequencies.put(s.charAt(i), frequencies.getOrDefault(s.charAt(i), 0) + 1);
        }
        return frequencies;
    }
}
