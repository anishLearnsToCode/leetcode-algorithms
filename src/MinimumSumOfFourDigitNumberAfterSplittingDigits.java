// https://leetcode.com/problems/minimum-sum-of-four-digit-number-after-splitting-digits
// T: O(1)
// S: O(1)

import java.util.Arrays;

public class MinimumSumOfFourDigitNumberAfterSplittingDigits {
    public int minimumSum(int num) {
        final int digit1 = num / 1000;
        final int digit2 = (num / 100) % 10;
        final int digit3 = (num / 10) % 10;
        final int digit4 = num % 10;

        final int[] digits = { digit1, digit2, digit3, digit4 };
        Arrays.sort(digits);

        return toNumber(digits[0], digits[2]) + toNumber(digits[1], digits[3]);
    }

    private int toNumber(int a, int b) {
        return 10 * a + b;
    }
}
