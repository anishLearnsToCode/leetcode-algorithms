// https://leetcode.com/problems/multiply-strings
// T: O(|num1| * |num2|)
// S: O(|num1| + |num2|)

public class MultiplyStrings {
    private static final String ZERO = "0";
    private static final String ONE = "1";

    public String multiply(String num1, String num2) {
        if (ZERO.equals(num1) || ZERO.equals(num2)) return ZERO;
        if (ONE.equals(num1)) return num2;
        if (ONE.equals(num2)) return num1;

        StringBuilder result = new StringBuilder(ZERO);
        for (int i = num2.length() - 1 ; i >= 0 ; i--) {
            result = add(result, multiply(num1, num2.charAt(i) - '0', num2.length() - i - 1));
        }
        return result.toString();
    }

    private StringBuilder multiply(String number, int digit, int factor) {
        final StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = number.length() - 1 ; i >= 0 ; i--) {
            int val = (number.charAt(i) - '0') * digit + carry;
            result.append(val % 10);
            carry = val / 10;
        }
        if (carry > 0) result.append(carry);
        return result.reverse().append(ZERO.repeat(factor));
    }

    private StringBuilder add(StringBuilder a, StringBuilder b) {
        final StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1 ; i >= 0 || j >= 0 ; i--, j--) {
            int val = getDigit(a, i) + getDigit(b, j) + carry;
            result.append(val % 10);
            carry = val / 10;
        }
        if (carry > 0) result.append(carry);
        return result.reverse();
    }

    private int getDigit(StringBuilder string, int index) {
        if (index < 0) return 0;
        return string.charAt(index) - '0';
    }
}
