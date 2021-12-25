// https://leetcode.com/problems/find-target-indices-after-sorting-array
// T: O(|nums|)
// S: O(|nums|)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTargetIndicesAfterSortingArray {
    public List<Integer> targetIndices(int[] nums, int target) {
        final Map<Integer, Integer> frequency = getFrequency(nums);
        int index = 0;
        for (int i = 0 ; i < target ; i++) {
            index += frequency.getOrDefault(i, 0);
        }
        return indices(index, frequency.getOrDefault(target, 0));
    }

    private Map<Integer, Integer> getFrequency(int[] array) {
        final Map<Integer, Integer> result = new HashMap<>();
        for (int element : array) {
            result.put(element, result.getOrDefault(element, 0) + 1);
        }
        return result;
    }

    private List<Integer> indices(int start, int length) {
        final List<Integer> result = new ArrayList<>(length);
        for (int i = 0 ; i < length ; i++) {
            result.add(start++);
        }
        return result;
    }
}
