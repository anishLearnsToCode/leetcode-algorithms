// https://leetcode.com/problems/largest-3-same-digit-number-in-string
// T: O(|s|)
// S: O(1)

public class Largest3SameDigitNumberInString {
    public String largestGoodInteger(String num) {
        char current = num.charAt(0), result = '0' - 1;
        for (int index = 1, count = 1 ; index < num.length() ; index++) {
            if (num.charAt(index) == current) {
                count++;
            } else {
                current = num.charAt(index);
                count = 1;
            }

            if (count >= 3 && current > result) {
                result = current;
            }
        }

        if (result >= '0') {
            return (result + "").repeat(3);
        } else return "";
    }
}
