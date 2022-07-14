// https://leetcode.com/problems/ugly-number-ii
// T: O(N)
// S: O(N)

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        final int[] dp = new int[n];
        dp[0] = 1;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int index2 = 0, index3 = 0, index5 = 0;

        for(int i = 1 ; i < n ; i++) {
            final int uglyNumber = min(factor2, factor3, factor5);
            dp[i] = uglyNumber;
            if (uglyNumber == factor2) factor2 = 2 * dp[++index2];
            if (uglyNumber == factor3) factor3 = 3 * dp[++index3];
            if (uglyNumber == factor5) factor5 = 5 * dp[++index5];
        }

        return dp[dp.length - 1];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
