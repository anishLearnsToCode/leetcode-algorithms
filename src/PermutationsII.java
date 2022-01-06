// https://leetcode.com/problems/permutations-ii
// T: O(n * n!)
// S: O(n * n!)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        final Map<Integer, Integer> frequencies = getFrequencies(nums);
        final List<List<Integer>> result = new ArrayList<>();
        permuteUnique(nums, result, frequencies, new LinkedList<>());
        return result;
    }

    private void permuteUnique(int[] array, List<List<Integer>> result, Map<Integer, Integer> frequencies, LinkedList<Integer> current) {
        if (current.size() == array.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() > 0) {
                entry.setValue(entry.getValue() - 1);
                current.add(entry.getKey());
                permuteUnique(array, result, frequencies, current);
                current.removeLast();
                entry.setValue(entry.getValue() + 1);
            }
        }
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }
}
