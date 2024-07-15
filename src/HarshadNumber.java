// https://leetcode.com/problems/harshad-number
// T: O(log(N))
// S: O(1)

public class HarshadNumber {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        final int sumOfDigits = sumOfDigits(x);
        if (x % sumOfDigits == 0) {
            return sumOfDigits;
        }
        return -1;
    }

    private static int sumOfDigits(int x) {
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}
