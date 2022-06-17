// https://leetcode.com/problems/maximum-product-subarray
// T: O(N)
// S: O(1)

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], maxSoFar = max, temp;
        for (int i = 1 ; i < nums.length ; i++) {
            int number = nums[i];
            temp = max(max * number, min * number, number);
            min = min(max * number, min * number, number);
            max = temp;
            maxSoFar = Math.max(maxSoFar, max);
        }
        return maxSoFar;
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
