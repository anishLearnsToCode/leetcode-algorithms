// https://leetcode.com/problems/fraction-to-recurring-decimal
// T: O(log(n / d)) but not sure, could use some mathematician's help
// S: O(log(n / d))

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    private static final String ZERO = "0";

    public String fractionToDecimal(long numerator, long denominator) {
        if (numerator == 0) return ZERO;

        StringBuilder result = new StringBuilder();
        result.append(isNegative(numerator, denominator) ? "-" : "");

        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);

        // integral part
        result.append(numerator / denominator);
        numerator %= denominator;
        if (numerator == 0) return result.toString();

        // fractional part
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(numerator, result.length());

        while (numerator != 0) {
            numerator *= 10;
            result.append(numerator / denominator);
            numerator %= denominator;
            if (map.containsKey(numerator)) {
                int index = map.get(numerator);
                result.insert(index, "(");
                result.append(")");
                break;
            } else map.put(numerator, result.length());
        }

        return result.toString();
    }

    private boolean isNegative(long numerator, long denominator) {
        return (numerator > 0) ^ (denominator > 0);
    }
}
