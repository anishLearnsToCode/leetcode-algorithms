// https://leetcode.com/problems/ugly-number-ii
// T: O(N)
// S: O(N)

public class UglyNumberII {
    public int nthUglyNumber(int n) {
        final int[] dp = new int[n];
        dp[0] = 1;
        int index2, index3, index5;
        index2 = index3 = index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;

        for(int i = 1 ; i < n ; i++) {
            final int uglyNumber = min(factor2, factor3, factor5);
            dp[i] = uglyNumber;
            if(factor2 == uglyNumber) factor2 = 2 * dp[++index2];
            if(factor3 == uglyNumber) factor3 = 3 * dp[++index3];
            if(factor5 == uglyNumber) factor5 = 5 * dp[++index5];
        }

        return dp[n-1];
    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
