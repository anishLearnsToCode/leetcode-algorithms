// https://leetcode.com/problems/largest-number-after-digit-swaps-by-parity
// T: O(log(n) log(log(n)))
// S: O(log(n))

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LargestNumberAfterDigitSwapsByParity {
    public int largestInteger(int num) {
        final String number = num + "";
        final List<Integer> evenDigits = getEvenDigits(number);
        final List<Integer> oddDigits = getOddDigits(number);

        evenDigits.sort(Comparator.reverseOrder());
        oddDigits.sort(Comparator.reverseOrder());

        final StringBuilder result = new StringBuilder();
        for (int i = 0, evenIndex = 0, oddIndex = 0; i < number.length() ; i++) {
            if (isOddDigit(number, i)) {
                result.append(oddDigits.get(oddIndex++));
            } else {
                result.append(evenDigits.get(evenIndex++));
            }
        }

        return Integer.parseInt(result.toString());
    }

    private boolean isOddDigit(String number, int index) {
        return (number.charAt(index) - '0') % 2 == 1;
    }

    private List<Integer> getEvenDigits(String string) {
        final List<Integer> result = new ArrayList<>();
        for (int index = 0 ; index < string.length() ; index++) {
            if (!isOddDigit(string, index)) result.add(string.charAt(index) - '0');
        }
        return result;
    }

    private List<Integer> getOddDigits(String string) {
        final List<Integer> result = new ArrayList<>();
        for (int index = 0 ; index < string.length() ; index++) {
            if (isOddDigit(string, index)) result.add(string.charAt(index) - '0');
        }
        return result;
    }
}
