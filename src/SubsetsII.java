// https://leetcode.com/problems/subsets-ii
// T: O(2^n)
// S: O(n * 2^n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> result = new ArrayList<>();
        helper(result, new LinkedList<>(), nums, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, LinkedList<Integer> current, int[] numbers, int index) {
        result.add(new ArrayList<>(current));
        for(int i = index ; i < numbers.length ; i++) {
            if(i > index && numbers[i] == numbers[i-1]) continue;
            current.add(numbers[i]);
            helper(result, current, numbers, i + 1);
            current.removeLast();
        }
    }
}
