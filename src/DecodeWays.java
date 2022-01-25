// https://leetcode.com/problems/decode-ways
// T: O(n)
// S: O(1)

public class DecodeWays {
    private static final char ZERO = '0';

    public int numDecodings(String s) {
        int previous = 1, current, temp;
        current = s.charAt(s.length() - 1) > ZERO ? 1 : 0;
        for (int i = s.length() - 2 ; i >= 0 ; i--) {
            if (s.charAt(i) == ZERO) {
                previous = current;
                current = 0;
            } else {
                temp = current;
                current += isValidAlphabet(s.charAt(i), s.charAt(i + 1)) ? previous : 0;
                previous = temp;
            }
        }
        return current;
    }

    private boolean isValidAlphabet(char a, char b) {
        return (a - ZERO) * 10 + (b - ZERO) <= 26;
    }
}
