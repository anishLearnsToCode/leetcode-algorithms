// https://leetcode.com/problems/alternating-digit-sum
// T: O(log(n))
// S: O(1)

public class AlternatingDigitSum {
    public int alternateDigitSum(int n) {
        final String number = n + "";
        int sum = 0;
        for (int index = 0, parity = 1 ; index < number.length() ; index++, parity *= -1) {
            sum += parity * (number.charAt(index) - '0');
        }
        return sum;
    }
}
