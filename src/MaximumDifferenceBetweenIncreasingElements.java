// https://leetcode.com/problems/maximum-difference-between-increasing-elements
// T: O(N)
// S: O(1)

public class MaximumDifferenceBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int maxDifference = -1;
        for (int index = nums.length - 2, currentMax = nums[nums.length - 1] ; index >= 0 ; index--) {
            if (currentMax > nums[index]) {
                maxDifference = Math.max(maxDifference, currentMax - nums[index]);
            }
            currentMax = Math.max(currentMax, nums[index]);
        }
        return maxDifference;
    }
}
