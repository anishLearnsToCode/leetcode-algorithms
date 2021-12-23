// https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal
// T: O(|words| * |word|)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharactersToMakeAllStringsEqual {
    public boolean makeEqual(String[] words) {
        if (words.length == 1) return true;
        final Map<Character, Integer> frequencies = getCharacterFrequencies(words);
        for (int frequency : frequencies.values()) {
            if (frequency % words.length != 0) return false;
        }
        return true;
    }

    private Map<Character, Integer> getCharacterFrequencies(String[] words) {
        final Map<Character, Integer> frequencies = new HashMap<>();
        for (String word : words) {
            for (int i = 0 ; i < word.length() ; i++) {
                frequencies.put(word.charAt(i), frequencies.getOrDefault(word.charAt(i), 0) + 1);
            }
        }
        return frequencies;
    }
}
