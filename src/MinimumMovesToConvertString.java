// https://leetcode.com/problems/minimum-moves-to-convert-string
// T: O(|s|)
// S: O(1)

public class MinimumMovesToConvertString {
    public int minimumMoves(String s) {
        int conversions = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == 'X') {
                conversions++;
                i += 2;
            }
        }
        return conversions;
    }
}
