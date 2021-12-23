// https://leetcode.com/problems/sum-of-digits-of-string-after-convert
// T: O(|s|* k)
// S: O(|s|)

public class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        final String convertedString = convert(s);
        int num = sumOfDigits(convertedString);
        for (int i = 0 ; i < k - 1 ; i++) {
            num = sumOfDigits(num);
        }
        return num;
    }

    private String convert(String s) {
        final StringBuilder result = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++) {
            result.append(s.charAt(i) - 'a' + 1);
        }
        return result.toString();
    }

    private int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private int sumOfDigits(String number) {
        int sum = 0;
        for (int i = 0 ; i < number.length() ; i++) {
            sum += number.charAt(i) - '0';
        }
        return sum;
    }
}
