// https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse
// T: O(N^2)
// S: O(1)

public class ExistenceOfASubstringInAStringAndItsReverse {
    public boolean isSubstringPresent(String s) {
        for (int i = 0 ; i < s.length() - 1 ; i++) {
            final String substring = s.substring(i, i + 2);
            if (reverseStringContains(s, substring)) {
                return true;
            }
        }
        return false;
    }

    private static boolean reverseStringContains(String s, String substring) {
        for (int i = s.length() - 1 ; i > 0 ; i--) {
            if (s.charAt(i) == substring.charAt(0) && s.charAt(i - 1) == substring.charAt(1)) {
                return true;
            }
        }
        return false;
    }
}
