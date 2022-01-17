// https://leetcode.com/problems/subsets
// T: O(n * 2^n)
// S: O(n)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        final List<List<Integer>> result = new ArrayList<>();
        addSubsets(nums, 0, result, new LinkedList<>());
        return result;
    }

    private void addSubsets(int[] array, int index, List<List<Integer>> result, LinkedList<Integer> current) {
        if (index == array.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(array[index]);
        addSubsets(array, index + 1, result, current);
        current.removeLast();
        addSubsets(array, index + 1, result, current);
    }
}
