// https://leetcode.com/problems/longest-palindromic-substring

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(isPalindrome("caba", 1, 4));
    }

    public static String longestPalindrome(String s) {
        final String s2 = new StringBuilder(s).reverse().toString();
        final int rows = s.length() + 1, columns = s2.length() + 1;
        final int[][] dp = new int[2][columns];
        int maxLength = 0, startIndex = -1;

        for (int row = 1, i = 1 ; row < rows ; row++, i ^= 1) {
            for (int column = 1 ; column < columns ; column++) {
                dp[i][column] = s.charAt(row - 1) == s2.charAt(column - 1) ? dp[i ^ 1][column - 1] + 1 : 0;
                if (dp[i][column] > maxLength && isPalindrome(s, row - dp[i][column], row)) {
                    maxLength = dp[i][column];
                    startIndex = row - maxLength;
                }
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    private static boolean isPalindrome(String s, int start, int end) {
        for (int i = start ; i < start + (end - start) / 2 ; i++) {
            if (s.charAt(i) != s.charAt(end - i - 1 + start)) {
                return false;
            }
        }
        return true;
    }
}
