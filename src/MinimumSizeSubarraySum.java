// https://leetcode.com/problems/minimum-size-subarray-sum
// T: O(N)
// S: O(1)

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] array) {
        int minSize = Integer.MAX_VALUE;
        for (int left = 0, right = 0, sum = 0 ; right < array.length ; right++) {
            sum += array[right];
            while (sum >= target) {
                minSize = Math.min(minSize, right - left + 1);
                sum -= array[left++];
            }
        }
        return minSize == Integer.MAX_VALUE ? 0 : minSize;
    }
}
