// https://leetcode.com/problems/number-of-good-pairs
// T: O(n)
// S: O(n)

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> frequencies = getFrequencies(nums);
        int goodPairs = 0;
        for (int frequency : frequencies.values()) {
            goodPairs += nC2(frequency);
        }
        return goodPairs;
    }

    private int nC2(int x) {
        return (x * (x - 1)) / 2;
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }
}
