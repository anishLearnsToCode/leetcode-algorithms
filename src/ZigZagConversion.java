// https://leetcode.com/problems/zigzag-conversion
// T: O(|s|)
// S: O(|s|)

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        if (numRows == 1) return s;
        final StringBuilder result = new StringBuilder();
        final int jumpSize = (numRows - 1) * 2;

        // first row
        for (int i = 0 ; i < s.length() ; i += jumpSize) {
            result.append(s.charAt(i));
        }

        for (int row = 1 ; row < numRows - 1 ; row++) {
            int[] jumps = {jumpSize - 2 * row, 2 * row};
            for (int i = row, k = 0 ; i < s.length() ; k ^= 1) {
                result.append(s.charAt(i));
                i += jumps[k];
            }
        }

        // last row
        for (int i = numRows - 1 ; i < s.length() ; i += jumpSize) {
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}
