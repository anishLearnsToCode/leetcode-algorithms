// https://leetcode.com/problems/check-if-number-has-equal-digit-count-and-digit-value
// T: O(|num|)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class CheckIfNumberHasEqualDigitCountAndDigitValue {
    public boolean digitCount(String num) {
        final Map<Integer, Integer> digitFrequencies = getDigitFrequencies(num);
        for (int index = 0 ; index < num.length() ; index++) {
            if ((num.charAt(index) - '0') != digitFrequencies.getOrDefault(index, 0)) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, Integer> getDigitFrequencies(String number) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int i = 0 ; i < number.length() ; i++) {
            final int digit = number.charAt(i) - '0';
            frequencies.put(digit, frequencies.getOrDefault(digit, 0) + 1);
        }
        return frequencies;
    }
}
