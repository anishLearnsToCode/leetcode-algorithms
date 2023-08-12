// https://leetcode.com/problems/longest-alternating-subarray
// T: O(N)
// S: O(1)

public class LongestAlternatingSubarray {
    public int alternatingSubarray(int[] array) {
        int maxLength = 0, j = 0;
        for (int i = 0 ; i < array.length ; i = Math.max(i + 1, j - 1)) {
            for (j = i + 1 ; j < array.length && array[j] == array[i] + (j - i) % 2 ; j++) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength > 1 ? maxLength : -1;
    }
}
