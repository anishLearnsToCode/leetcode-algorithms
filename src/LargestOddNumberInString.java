// https://leetcode.com/problems/largest-odd-number-in-string
// T: O(|num|)
// S: O(num)

public class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1 ; i >= 0 ; i--) {
            if (isOddDigit(num.charAt(i))) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    private boolean isOddDigit(char digit) {
        return (digit - '0') % 2 == 1;
    }
}
