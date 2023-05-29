// https://leetcode.com/problems/largest-local-values-in-a-matrix
// T: O(n ^ 2)
// S: O(n ^ 2)

public class LargestLocalValuesInAMatrix {
    public int[][] largestLocal(int[][] grid) {
        final int n = grid.length;
        final int[][] result = new int[n - 2][n - 2];

        for (int row = 1 ; row < n - 1 ; row++) {
            for (int column = 1 ; column < n - 1 ; column++) {
                result[row - 1][column - 1] = localMax(grid, row, column);
            }
        }

        return result;
    }

    private int localMax(int[][] grid, int row, int column) {
        int max = Integer.MIN_VALUE;
        for (int i = row - 1 ; i <= row + 1 ; i++) {
            for (int j = column - 1 ; j <= column + 1 ; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
