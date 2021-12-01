import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0, index = 0;
        for ( ; index < nums.length && k > 0 ; index++) {
            if (nums[index] < 0) {
                sum -= nums[index];
                k--;
            } else break;
        }
        if ((k & 1) == 1) {
            if (index < nums.length) {
                if (index == 0) sum -= nums[index];
                else if (-nums[index - 1] < nums[index]) sum += 2 * nums[index - 1] + nums[index];
                else sum -= nums[index];
                index++;
            } else return sum + 2 * nums[nums.length - 1];
        }
        for ( ; index < nums.length ; index++) {
            sum += nums[index];
        }
        return sum;
    }
}
