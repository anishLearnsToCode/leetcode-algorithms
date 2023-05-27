// https://leetcode.com/problems/rearrange-characters-to-make-target-string
// T: O(|s| + |target|)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class RearrangeCharactersToMakeTargetString {
    public int rearrangeCharacters(String s, String target) {
        final Map<Character, Integer> sCharFrequencies = getCharFrequencies(s);
        final Map<Character, Integer> targetCharFrequencies = getCharFrequencies(target);

        int maxCopies = Integer.MAX_VALUE;
        for (char targetChar : targetCharFrequencies.keySet()) {
            maxCopies = Math.min(maxCopies, sCharFrequencies.getOrDefault(targetChar, 0) / targetCharFrequencies.get(targetChar));
        }
        return maxCopies;
    }

    private Map<Character, Integer> getCharFrequencies(String string) {
        final Map<Character, Integer> result = new HashMap<>();
        for (int i = 0 ; i < string.length() ; i++) {
            result.put(string.charAt(i), result.getOrDefault(string.charAt(i), 0) + 1);
        }
        return result;
    }
}
