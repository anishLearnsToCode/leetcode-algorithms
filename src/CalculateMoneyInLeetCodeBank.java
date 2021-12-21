public class CalculateMoneyInLeetCodeBank {
    private static final int SUM_7 = 28;

    public int totalMoney (int n) {
        final int r = ceil((double) n / 7);
        return r * SUM_7
                + 7 * summation(r - 1)
                - (summation(6 + r) - summation(n % 7 == 0 ? 6 + r : r - 1 + n % 7));
    }

    private int ceil(double d) {
        return (int) Math.ceil(d);
    }

    private int summation(int x) {
        if (x <= 0) return 0;
        return (x * (x + 1)) / 2;
    }
}
