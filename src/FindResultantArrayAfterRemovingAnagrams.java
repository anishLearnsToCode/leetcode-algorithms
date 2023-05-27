// https://leetcode.com/problems/find-resultant-array-after-removing-anagrams
// T: O(|words| * |words[i]|)
// S: O(|words[i]|)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindResultantArrayAfterRemovingAnagrams {
    public List<String> removeAnagrams(String[] words) {
        final List<String> result = new ArrayList<>();
        result.add(words[0]);
        Map<Character, Integer> wordSignature = getCharacterFrequencies(words[0]);
        for (int index = 1 ; index < words.length ; index++) {
            final String word = words[index];
            final Map<Character, Integer> wordCharFrequencies = getCharacterFrequencies(word);
            if (!wordCharFrequencies.equals(wordSignature)) {
                result.add(word);
                wordSignature = wordCharFrequencies;
            }
        }
        return result;
    }

    private Map<Character, Integer> getCharacterFrequencies(String string) {
        final Map<Character, Integer> result = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            result.put(string.charAt(index), result.getOrDefault(string.charAt(index), 0) + 1);
        }
        return result;
    }
}
