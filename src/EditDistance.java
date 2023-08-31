// https://leetcode.com/problems/edit-distance
// T: O(m * n)
// S: O(m * n)

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if (word1.isEmpty()) return word2.length();
        if (word2.isEmpty()) return word1.length();

        final int rows = word1.length() + 1, columns = word2.length() + 1;
        final int[][] dp = new int[rows][columns];

        dp[0][0] = 0;

        // first row
        for (int column = 1 ; column < columns ; column++) {
            dp[0][column] = column;
        }

        // first column
        for (int row = 1 ; row < rows ; row++) {
            dp[row][0] = row;
        }

        // rest of table
        for (int row = 1 ; row < rows ; row++) {
            for (int column = 1 ; column < columns ; column++) {
                if (word1.charAt(row - 1) == word2.charAt(column - 1)) {
                    dp[row][column] = dp[row - 1][column - 1];
                } else {
                    dp[row][column] = min(dp[row - 1][column - 1], dp[row - 1][column], dp[row][column - 1]) + 1;
                }
            }
        }

        return dp[rows - 1][columns - 1];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
