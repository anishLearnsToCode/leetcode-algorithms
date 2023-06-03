// https://leetcode.com/problems/count-the-digits-that-divide-a-number
// T: O(log(N))
// S: O(1)

public class CountTheDigitsThatDivideANumber {
    public int countDigits(int num) {
        final String number = num + "";
        int divisors = 0;
        for (int index = 0 ; index < number.length() ; index++) {
            int digit = number.charAt(index) - '0';
            if (num % digit == 0) divisors++;
        }
        return divisors;
    }
}
