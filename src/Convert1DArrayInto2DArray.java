// https://leetcode.com/problems/convert-1d-array-into-2d-array
// T: O(n * m)
// S: O(n * m)

public class Convert1DArrayInto2DArray {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) return new int[0][];
        final int[][] result = new int[m][n];
        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ; j < n ; j++) {
                result[i][j] = original[n * i + j];
            }
        }
        return result;
    }
}
