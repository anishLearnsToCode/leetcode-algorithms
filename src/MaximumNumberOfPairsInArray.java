// https://leetcode.com/problems/maximum-number-of-pairs-in-array
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfPairsInArray {
    public int[] numberOfPairs(int[] nums) {
        final Map<Integer, Integer> digitFrequencies = getFrequencies(nums);
        final int numberOfPairs = getNumberOfPairs(digitFrequencies);
        return new int[] { numberOfPairs, nums.length - 2 * numberOfPairs };
    }

    private int getNumberOfPairs(Map<Integer, Integer> frequencies) {
        int result = 0;
        for (int frequency : frequencies.values()) {
            result += frequency / 2;
        }
        return result;
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        final Map<Integer, Integer> result = new HashMap<>();
        for (int element : array) {
            result.put(element, result.getOrDefault(element, 0) + 1);
        }
        return result;
    }
}
