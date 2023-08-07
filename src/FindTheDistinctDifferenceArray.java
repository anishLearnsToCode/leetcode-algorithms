// https://leetcode.com/problems/find-the-distinct-difference-array
// N: length of array
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class FindTheDistinctDifferenceArray {
    public int[] distinctDifferenceArray(int[] nums) {
        final Map<Integer, Integer> leftFrequencies = new HashMap<>();
        final Map<Integer, Integer> rightFrequencies = getNumberFrequencies(nums);
        final int[] result = new int[nums.length];
        int k = 0;
        for (int element : nums) {
            addToFrequency(leftFrequencies, element);
            removeFromFrequency(rightFrequencies, element);
            result[k++] = leftFrequencies.size() - rightFrequencies.size();
        }
        return result;
    }

    private void removeFromFrequency(Map<Integer, Integer> frequencies, int element) {
        if (frequencies.get(element) == 1) {
            frequencies.remove(element);
        } else {
            frequencies.put(element, frequencies.getOrDefault(element, 0) - 1);
        }
    }

    private void addToFrequency(Map<Integer, Integer> frequencies, int element) {
        frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
    }

    private Map<Integer, Integer> getNumberFrequencies(int[] array) {
        final Map<Integer, Integer> result = new HashMap<>();
        for (int element : array) {
            result.put(element, result.getOrDefault(element, 0) + 1);
        }
        return result;
    }
}
