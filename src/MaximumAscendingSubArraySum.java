public class MaximumAscendingSubArraySum {
    public int maxAscendingSum(int[] nums) {
        int maxSum = nums[0];
        for (int index = 1, current = nums[0] ; index < nums.length ; index++) {
            if (nums[index] > nums[index - 1]) {
                current += nums[index];
            } else current = nums[index];
            maxSum = Math.max(maxSum, current);
        }
        return maxSum;
    }
}
