// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences
// T: O(|s|)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class CheckIfAllCharactersHaveEqualNumberOfOccurrences {
    public boolean areOccurrencesEqual(String s) {
        final Map<Character, Integer> charFrequencies = getCharacterFrequencies(s);
        int commonFrequency = charFrequencies.get(s.charAt(0));
        for (int frequency : charFrequencies.values()) {
            if (frequency != commonFrequency) return false;
        }
        return true;
    }

    private Map<Character, Integer> getCharacterFrequencies(String s) {
        final Map<Character, Integer> characterFrequencies = new HashMap<>(26);
        for (int i = 0 ; i < s.length() ; i++) {
            characterFrequencies.put(s.charAt(i), characterFrequencies.getOrDefault(s.charAt(i), 0) + 1);
        }
        return characterFrequencies;
    }
}
