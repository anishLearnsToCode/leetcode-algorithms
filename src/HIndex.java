// https://leetcode.com/problems/h-index
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class HIndex {
    public int hIndex(int[] citations) {
        final Map<Integer, Integer> citationFrequencies = getFrequencies(citations);
        final int maxCitation = max(citations);
        for (int hIndex = maxCitation, papers = 0 ; hIndex >= 0 ; hIndex--) {
            papers += citationFrequencies.getOrDefault(hIndex, 0);
            if (papers >= hIndex) return hIndex;
        }
        return 0;
    }

    private int max(int[] array) {
        int result = 0;
        for (int element : array) {
            result = Math.max(result, element);
        }
        return result;
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }
}
