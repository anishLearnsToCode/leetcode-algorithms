// https://leetcode.com/problems/clear-digits
// T: O(N)
// S: O(N)

public class ClearDigits {
    public String clearDigits(String s) {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0, chars = 0, digits = 0 ; i < s.length() ; i++) {
            if (Character.isDigit(s.charAt(i))) {
                builder.deleteCharAt(builder.length() - 1);
            } else {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();
    }
}
