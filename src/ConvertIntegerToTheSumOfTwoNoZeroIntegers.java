public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1 ; i <= n / 2 ; i++) {
            if (isNonZeroInteger(i) && isNonZeroInteger(n - i)) {
                return new int[] {i, n - i};
            }
        }
        return new int[0];
    }

    private boolean isNonZeroInteger(int n) {
        while (n > 0) {
            if (n % 10 == 0) return false;
            n /= 10;
        }
        return true;
    }
}
