// https://leetcode.com/problems/maximal-square
// T: O(m * n)
// S: O(m * n)

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        final int rows = matrix.length, columns = matrix[0].length;
        final int[][] dp = new int[rows][columns];

        assignFirstRowInDPMatrix(dp, matrix);
        assignFirstColumnInDPMatrix(dp, matrix);

        int maxSideLen = contains1(dp) ? 1 : 0;

        for (int row = 1 ; row < rows ; row++) {
            for (int column = 1 ; column < columns ; column++) {
                if (isOne(matrix[row][column])) {
                    dp[row][column] = min(dp[row - 1][column], dp[row][column - 1], dp[row - 1][column - 1]) + 1;
                } else dp[row][column] = 0;
                maxSideLen = Math.max(maxSideLen, dp[row][column]);
            }
        }

        return maxSideLen * maxSideLen;
    }

    private boolean contains1(int[][] dp) {
        return contains1InFirstRow(dp) || contains1InFirstColumn(dp);
    }

    private boolean contains1InFirstRow(int[][] dp) {
        for (int element : dp[0]) {
            if (element == 1) return true;
        }
        return false;
    }

    private boolean contains1InFirstColumn(int[][] dp) {
        for (int[] row : dp) {
            if (row[0] == 1) return true;
        }
        return false;
    }

    private boolean isOne(char character) {
        return character == '1';
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private void assignFirstRowInDPMatrix(int[][] dp, char[][] matrix) {
        for (int column = 0 ; column < matrix[0].length ; column++) {
            dp[0][column] = matrix[0][column] - '0';
        }
    }

    private void assignFirstColumnInDPMatrix(int[][] dp, char[][] matrix) {
        for (int row = 0 ; row < matrix.length ; row++) {
            dp[row][0] = matrix[row][0] - '0';
        }
    }
}
