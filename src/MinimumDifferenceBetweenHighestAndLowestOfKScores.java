// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores
// T: O(Nlog(N))
// S: O(1)

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0 ; i < nums.length - k + 1 ; i++) {
            minDifference = Math.min(minDifference, nums[i + k - 1] - nums[i]);
        }
        return minDifference;
    }
}
