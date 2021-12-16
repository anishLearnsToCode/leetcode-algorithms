public class RunningSumOf1DArray {
    public int[] runningSum(int[] nums) {
        final int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int index = 1 ; index < nums.length ; index++) {
            sum[index] = nums[index] + sum[index - 1];
        }
        return sum;
    }
}
