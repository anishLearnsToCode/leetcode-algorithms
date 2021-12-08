public class PrimeArrangements {
    private static final int[] PRIME_DENSITY = {
            0, 1, 2, 2, 3, 3, 4, 4, 4, 4,
            5, 5, 6, 6, 6, 6, 7, 7, 8, 8,
            8, 8, 9, 9, 9, 9, 9, 9, 10, 10,
            11, 11, 11, 11, 11, 11, 12, 12,
            12, 12, 13, 13, 14, 14, 14, 14,
            15, 15, 15, 15, 15, 15, 16, 16,
            16, 16, 16, 16, 17, 17, 18, 18,
            18, 18, 18, 18, 19, 19, 19, 19,
            20, 20, 21, 21, 21, 21, 21, 21,
            22, 22, 22, 22, 23, 23, 23, 23,
            23, 23, 24, 24, 24, 24, 24, 24,
            24, 24, 25, 25, 25, 25
    };

    private static final int MOD = 1000_000_007;

    public int numPrimeArrangements(int n) {
        final int primeNumbers = PRIME_DENSITY[n - 1];
        return factorialMod(primeNumbers, factorialMod(n - primeNumbers))  % MOD;
    }

    private int factorialMod(long number, final long start) {
        long result = start;
        while (number > 1) {
            result = (result * number) % MOD;
            number--;
        }
        return (int) result;
    }

    private int factorialMod(int number) {
        return factorialMod(number, 1);
    }
}
