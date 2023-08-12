// https://leetcode.com/problems/remove-trailing-zeros-from-a-string
// T: O(|s|)
// S: O(|s|)

public class RemoveTrailingZerosFromAString {
    public String removeTrailingZeros(String num) {
        for (int i = num.length() - 1;  i >= 0 ; i--) {
            if (num.charAt(i) != '0') {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
