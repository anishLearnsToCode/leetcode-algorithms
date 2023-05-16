// https://leetcode.com/problems/calculate-digit-sum-of-a-string
// T: O(log(n))
// S: O(log(n))

public class CalculateDigitSumOfAString {
    public String digitSum(String s, int k) {
        if (s.length() <= k) return s;
        final StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i += k) {
            final String group = s.substring(i, Math.min(i + k, s.length()));
            final int groupSum = digitSum(group);
            result.append(groupSum);
        }
        return digitSum(result.toString(), k);
    }

    private int digitSum(String number) {
        int sum = 0;
        for (int index = 0 ; index < number.length() ; index++) {
            sum += toInt(number.charAt(index));
        }
        return sum;
    }

    private int toInt(char x) {
        return x - '0';
    }
}
