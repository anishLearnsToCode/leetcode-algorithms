// https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray
// T: O(N)
// S: O(1)

public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    public int longestMonotonicSubarray(int[] array) {
        return Math.max(
            lengthLongestIncreasingSubarray(array),
            lengthLongestDecreasingSubarray(array)
        );
    }

    private static int lengthLongestIncreasingSubarray(int[] array) {
        int length = 1;
        for (int i = 1, current = 1 ; i < array.length ; i++) {
            if (array[i] > array[i - 1]) {
                current++;
            } else {
                current = 1;
            }
            length = Math.max(length, current);
        }
        return length;
    }

    private static int lengthLongestDecreasingSubarray(int[] array) {
        int length = 1;
        for (int i = 1, current = 1 ; i < array.length ; i++) {
            if (array[i] < array[i - 1]) {
                current++;
            } else {
                current = 1;
            }
            length = Math.max(length, current);
        }
        return length;
    }
}
