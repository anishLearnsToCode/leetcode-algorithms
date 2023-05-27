// https://leetcode.com/problems/remove-digit-from-number-to-maximize-result
// T: O(|number|)
// S: O(|number|)

import java.util.ArrayList;
import java.util.List;

public class RemoveDigitFromNumberToMaximizeResult {
    public String removeDigit(String number, char digit) {
        final List<Integer> digitIndices = getIndices(number, digit);
        for (int index : digitIndices) {
            if (index + 1 < number.length() && number.charAt(index) < number.charAt(index + 1)) {
                return number.substring(0, index) + number.substring(index + 1);
            }
        }
        int lastIndex = digitIndices.get(digitIndices.size() - 1);
        return number.substring(0, lastIndex) + number.substring(lastIndex + 1);
    }

    private List<Integer> getIndices(String number, char digit) {
        final List<Integer> result = new ArrayList<>();
        for (int index = 0 ; index < number.length() ; index++) {
            if (number.charAt(index) == digit) {
                result.add(index);
            }
        }
        return result;
    }
}
