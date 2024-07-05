// https://leetcode.com/problems/count-symmetric-integers
// T: O(N)
// S: O(1)

public class CountSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int start = low ; start <= high ; start++) {
            final String number = start + "";
            if (isSymmetric(number)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isSymmetric(String number) {
        if (number.length() % 2 != 0) {
            return false;
        }
        final String firstHalf = number.substring(0, number.length() / 2);
        final String secondHalf = number.substring(number.length() / 2);
        return sumOfDigits(firstHalf) == sumOfDigits(secondHalf);
    }

    private static int sumOfDigits(final String number) {
        int sum = 0;
        for (int i = 0 ; i < number.length() ; i++) {
            sum += number.charAt(i) - '0';
        }
        return sum;
    }
}
