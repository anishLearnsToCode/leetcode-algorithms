// https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing
// T: O(N)
// S: O(1)

public class MinimumOperationsToMakeTheArrayIncreasing {
    public int minOperations(int[] nums) {
        int operations = 0;
        for (int index = 1, current = nums[0] ; index < nums.length ; index++) {
            operations += Math.max(0, current - nums[index] + 1);
            current = Math.max(current + 1, nums[index]);
        }
        return operations;
    }
}
