// https://leetcode.com/problems/count-common-words-with-one-occurrence
// T: O(|words1| + |words2|)
// S: O(|words1| + |words2|)

import java.util.HashMap;
import java.util.Map;

public class CountCommonWordsWithOneOccurrence {
    public int countWords(String[] words1, String[] words2) {
        final Map<String, Integer> words1Frequency = getFrequencies(words1);
        final Map<String, Integer> words2Frequency = getFrequencies(words2);
        int words = 0;
        for (Map.Entry<String, Integer> entry: words1Frequency.entrySet()) {
            if (entry.getValue() == 1 && words2Frequency.getOrDefault(entry.getKey(), 0) == 1) {
                words++;
            }
        }
        return words;
    }

    private Map<String, Integer> getFrequencies(String[] array) {
        final Map<String, Integer> frequencies = new HashMap<>();
        for (String s : array) {
            frequencies.put(s, frequencies.getOrDefault(s, 0) + 1);
        }
        return frequencies;
    }
}
