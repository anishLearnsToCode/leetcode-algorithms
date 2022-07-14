import java.util.Arrays;

public class UglyNumberIII {
    public static int nthUglyNumber(int n, int a, int b, int c) {
        final int[] dp = new int[n + 1];
        dp[0] = 1;
        int factorA = a, factorB = b, factorC = c;
        int indexA = 0, indexB = 0, indexC = 0;

        for (int i = 1 ; i < dp.length ; i++) {
            final int uglyNumber = min(factorA, factorB, factorC);
            dp[i] = uglyNumber;
            if (uglyNumber == factorA) factorA = a * dp[++indexA];
            if (uglyNumber == factorB) factorB = b * dp[++indexB];
            if (uglyNumber == factorC) factorC = c * dp[++indexC];
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length - 1];
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(100, 2, 3, 5));
    }
}
