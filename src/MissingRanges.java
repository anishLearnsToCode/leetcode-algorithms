// https://leetcode.com/problems/missing-ranges
// T: O(N)
// S: O(N)

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0) {
            return List.of(List.of(lower, upper));
        }

        final List<List<Integer>> result = new ArrayList<>();
        if (lower != nums[0]) {
            result.add(List.of(lower, nums[0] - 1));
        }
        for (int i = 0 ; i < nums.length - 1 ; i++) {
            if (nums[i + 1] - nums[i] > 1) {
                result.add(List.of(nums[i] + 1, nums[i + 1] - 1));
            }
        }
        if (nums[nums.length - 1] != upper) {
            result.add(List.of(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }
}
