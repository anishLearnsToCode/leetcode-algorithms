// https://leetcode.com/problems/find-the-sum-of-encrypted-integers
// T: O(N)
// S: O(1)

public class FindTheSumOfEncryptedIntegers {
    public int sumOfEncryptedInt(int[] array) {
        int sum = 0;
        for (int element : array) {
            sum += encryptedInteger(element);
        }
        return sum;
    }

    private static int encryptedInteger(int x) {
        int maxDigit = 0, digits = 0;
        while (x > 0) {
            maxDigit = Math.max(maxDigit, x % 10);
            digits++;
            x /= 10;
        }
        int result = 0;
        while (digits-- > 0) {
            result = 10 * result + maxDigit;
        }
        return result;
    }
}
