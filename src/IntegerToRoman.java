// https://leetcode.com/problems/integer-to-roman
// T: O(log n)
// S: O(log n)

public class IntegerToRoman {
    private static final String[] ROMAN_VALUES = new String[] { "I", "V", "X", "L", "C", "D", "M" };

    public String intToRoman(int num) {
        final StringBuilder builder = new StringBuilder();
        final String number = num + "";
        for (int i = 0 ; i < number.length() ; i++) {
            builder.append(getRomanString(number.charAt(i), number.length() - i - 1));
        }
        return builder.toString();
    }

    private static String getRomanString(char digit, int power) {
        if (digit == '4') {
            return ROMAN_VALUES[2 * power] + ROMAN_VALUES[2 * power + 1];
        }
        if (digit == '9') {
            return ROMAN_VALUES[2 * power] + ROMAN_VALUES[2 * power + 2];
        }

        return switch (digit) {
            case '1' -> ROMAN_VALUES[2 * power].repeat(1);
            case '2' -> ROMAN_VALUES[2 * power].repeat(2);
            case '3' -> ROMAN_VALUES[2 * power].repeat(3);
            case '5' -> ROMAN_VALUES[2 * power + 1];
            case '6' -> ROMAN_VALUES[2 * power + 1] + ROMAN_VALUES[2 * power].repeat(1);
            case '7' -> ROMAN_VALUES[2 * power + 1] + ROMAN_VALUES[2 * power].repeat(2);
            case '8' -> ROMAN_VALUES[2 * power + 1] + ROMAN_VALUES[2 * power].repeat(3);
            default -> "";
        };
    }
}
