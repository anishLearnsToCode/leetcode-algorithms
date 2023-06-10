// https://leetcode.com/problems/left-and-right-sum-differences
// T: O(N)
// S: O(N)

public class LeftAndRightSumDifferences {
    public int[] leftRightDifference(int[] nums) {
        final int[] result = new int[nums.length];
        int leftSum = 0, rightSum = sum(nums, 1, nums.length);

        for (int index = 0 ; index < nums.length ; index++) {
            result[index] = Math.abs(leftSum - rightSum);
            leftSum += nums[index];
            rightSum -= (index + 1 < nums.length ? nums[index + 1] : 0);
        }

        return result;
    }

    private int sum(int[] array, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex ; i < endIndex ; i++) {
            sum += array[i];
        }
        return sum;
    }
}
