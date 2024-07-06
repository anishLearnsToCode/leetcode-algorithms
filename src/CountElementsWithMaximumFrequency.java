// https://leetcode.com/problems/count-elements-with-maximum-frequency
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class CountElementsWithMaximumFrequency {
    public int maxFrequencyElements(int[] array) {
        final Map<Integer, Integer> frequencies = computeFrequencies(array);
        final int maxFrequency = getMaxFrequency(frequencies);
        return numberOfElementsWithFrequency(frequencies, maxFrequency);
    }

    private static Map<Integer, Integer> computeFrequencies(int[] array) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int element : array) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        return map;
    }

    private static int getMaxFrequency(final Map<Integer, Integer> frequencies) {
        return frequencies.values().stream().max(Integer::compareTo).get();
    }

    private static int numberOfElementsWithFrequency(Map<Integer, Integer> frequencies, int frequency) {
        int sum = 0;
        for (Map.Entry<Integer,Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == frequency) {
                sum += frequency;
            }
        }
        return sum;
    }
}
