// https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap
// T: O(|s|)
// S: O(|s|)

public class LexicographicallySmallestStringAfterASwap {
    public String getSmallestString(String s) {
        for (int i = 0 ; i < s.length() - 1 ; i++) {
            if (sameParity(s, i) && s.charAt(i) > s.charAt(i + 1)) {
                return swapCharWithNextChar(s, i);
            }
        }
        return s;
    }

    private static boolean sameParity(String s, int index) {
        return Integer.parseInt(s.charAt(index) + "") % 2 ==
                Integer.parseInt(s.charAt(index + 1) + "") % 2;
    }

    private static String swapCharWithNextChar(String s, int index) {
        return s.substring(0, index) + s.charAt(index + 1)
                + s.charAt(index) + s.substring(index + 2);
    }
}
