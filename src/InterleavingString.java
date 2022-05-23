// https://leetcode.com/problems/interleaving-string
// T: O(n * m)
// S: O(min(m, n))

public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        if (s1.length() < s2.length()) {
            String temp = s1;
            s1 = s2;
            s2 = temp;
        }

        final int rows = s1.length() + 1, columns = s2.length() + 1;
        final boolean[] dp = new boolean[columns];

        for (int row = 0 ; row < rows ; row++) {
            for (int column = 0 ; column < columns ; column++) {
                if (row == 0 && column == 0) {
                    dp[column] = true;
                } else if (row == 0) {
                    dp[column] = dp[column - 1] && s2.charAt(column - 1) == s3.charAt(row + column - 1);
                } else if (column == 0) {
                    dp[column] = dp[column] && s1.charAt(row - 1) == s3.charAt(row + column - 1);
                } else {
                    dp[column] = (s1.charAt(row - 1) == s3.charAt(row + column - 1) && dp[column])
                            || (s2.charAt(column - 1) == s3.charAt(row + column - 1) && dp[column - 1]);
                }
            }
        }

        return dp[columns - 1];
    }
}
