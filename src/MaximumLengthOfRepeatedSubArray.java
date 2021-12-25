// longest common subarray / longest common substring length
// https://leetcode.com/problems/maximum-length-of-repeated-subarray
// T: O(|nums1| * |nums2|)
// S: O(min(|nums1|, |nums2|))

public class MaximumLengthOfRepeatedSubArray {
    public int findLength(int[] nums1, int[] nums2) {
        final int rows = nums1.length + 1, columns = nums2.length + 1;
        final int[][] memory = new int[2][columns];
        int maxValue = 0;

        for (int row = 1, i = 1 ; row < rows ; row++, i ^= 1) {
            for (int column = 1 ; column < columns ; column++) {
                memory[i][column] = nums1[row - 1] == nums2[column - 1] ? 1 + memory[i ^ 1][column - 1] : 0;
                maxValue = Math.max(maxValue, memory[i][column]);
            }
        }

        return maxValue;
    }
}
