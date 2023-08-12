// https://leetcode.com/problems/neither-minimum-nor-maximum
// T: O(1)
// S: O(1)

public class NeitherMinimumNorMaximum {
    public int findNonMinOrMax(int[] nums) {
        if (nums.length < 3) return -1;
        final int max = Math.max(nums[0], nums[1]);
        final int min = Math.min(nums[0], nums[1]);

        if (nums[2] < min) return min;
        else if (nums[2] < max) return nums[2];
        return max;
    }
}
