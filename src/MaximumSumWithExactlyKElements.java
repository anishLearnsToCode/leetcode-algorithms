// https://leetcode.com/problems/maximum-sum-with-exactly-k-elements
// T: O(n)
// S: O(1)

import java.util.Arrays;

public class MaximumSumWithExactlyKElements {
    public int maximizeSum(int[] nums, int k) {
        final int maxElement = Arrays.stream(nums).max().getAsInt();
        return maxElement * k + summation(k - 1);
    }

    private int summation(int x) {
        return (x * (x + 1)) / 2;
    }
}
