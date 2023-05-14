// https://leetcode.com/problems/most-frequent-number-following-key-in-an-array
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class MostFrequentNumberFollowingKeyInAnArray {
    public int mostFrequent(int[] nums, int key) {
        final Map<Integer, Integer> targetToFrequency = getTargetFrequencies(nums, key);
        return mostFrequentTarget(targetToFrequency);
    }

    private Map<Integer, Integer> getTargetFrequencies(int[] array, int key) {
        final Map<Integer, Integer> result = new HashMap<>();
        for (int index = 0 ; index < array.length - 1 ; index++) {
            if (array[index] == key) {
                int target = array[index + 1];
                result.put(target, result.getOrDefault(target, 0) + 1);
            }
        }
        return result;
    }

    private int mostFrequentTarget(final Map<Integer, Integer> frequencies) {
        int target = -1, maxFrequency = -1;
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                target = entry.getKey();
            }
        }
        return target;
    }
}
