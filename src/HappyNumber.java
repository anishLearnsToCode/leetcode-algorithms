import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int number) {
        return isHappy(number, new HashSet<>());
    }

    private static boolean isHappy(long number, Set<Long> sum) {
        long sumSquaresDigits = sumDigitSquares(number);
        if (sumSquaresDigits == 1) {
            return true;
        }
        if (sum.contains(sumSquaresDigits)) {
            return false;
        }
        sum.add(sumSquaresDigits);
        return isHappy(sumSquaresDigits, sum);
    }

    private static long sumDigitSquares(long number) {
        long result = 0;
        while (number > 0) {
            result += Math.pow(number % 10, 2);
            number /= 10;
        }
        return result;
    }
}
