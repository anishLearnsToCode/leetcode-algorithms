// https://leetcode.com/problems/maximal-square
// T: O(m * n)
// S: O(n)

public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        final int columns = matrix[0].length;
        final int[] dp = new int[columns + 1];
        int maxSideLength = 0, prev = 0, temp;

        for (char[] row : matrix) {
            for (int column = 0; column < columns; column++) {
                temp = dp[column + 1];
                if (isOne(row[column])) {
                    dp[column + 1] = min(dp[column + 1], dp[column], prev) + 1;
                } else dp[column + 1] = 0;
                maxSideLength = Math.max(maxSideLength, dp[column + 1]);
                prev = temp;
            }
        }

        return maxSideLength * maxSideLength;
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private boolean isOne(char c) {
        return c == '1';
    }
}
