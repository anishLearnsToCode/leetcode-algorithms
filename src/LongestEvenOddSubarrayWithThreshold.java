// https://leetcode.com/problems/longest-even-odd-subarray-with-threshold
// T: O(N)
// S: O(N)

public class LongestEvenOddSubarrayWithThreshold {
    public int longestAlternatingSubarray(int[] array, int threshold) {
        final int[] dp = new int[array.length];
        dp[0] = array[0] % 2 == 0 && array[0] <= threshold ? 1 : 0;
        int maxLength = dp[0];
        for (int i = 1 ; i < dp.length ; i++) {
            if (array[i] <= threshold && array[i] % 2 != array[i - 1] % 2 && dp[i - 1] > 0) dp[i] = dp[i - 1] + 1;
            else if (array[i] % 2 == 0 && array[i] <= threshold) dp[i] = 1;
            else dp[i] = 0;
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
