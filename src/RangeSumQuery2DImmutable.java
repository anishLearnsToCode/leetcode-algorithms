// https://leetcode.com/problems/range-sum-query-2d-immutable
// n: matrix.length
// m: matrix[0].length


class NumMatrix {

    final int rows;
    final int columns;
    final int[][] dp;

    // T: O(n * m)
    // S: O(n * m)
    public NumMatrix(int[][] matrix) {
        this.rows = matrix.length;
        this.columns = matrix[0].length;
        this.dp = new int[rows][columns];

        // first row
        dp[0][0] = matrix[0][0];
        for (int column = 1 ; column < columns ; column++) {
            dp[0][column] = dp[0][column - 1] + matrix[0][column];
        }

        // first column
        for (int row = 1 ; row < rows ; row++) {
            dp[row][0] = dp[row - 1][0] + matrix[row][0];
        }

        // rest of the matrix
        for (int row = 1 ; row < rows ; row++) {
            for (int column = 1 ; column < columns ; column++) {
                dp[row][column] = dp[row - 1][column] + dp[row][column - 1] - dp[row - 1][column - 1]
                        + matrix[row][column];
            }
        }
    }

    // T: O(1)
    // S: O(1)
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = this.dp[row2][col2];
        if (row1 > 0) {
            result -= this.dp[row1 - 1][col2];
        }
        if (col1 > 0) {
            result -= this.dp[row2][col1 - 1];
        }
        if (row1 > 0 && col1 > 0) {
            result += this.dp[row1 - 1][col1 - 1];
        }
        return result;
    }
}

public class RangeSumQuery2DImmutable {

}
