// https://leetcode.com/problems/longest-palindromic-substring
// T: O(n^2)
// S: O(1)

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s.length() < 2) return s;
        int maxLen = 0, startIndex = -1;
        for (int i = 0, len ; i < s.length() - 1 ; i++) {
            len = palindromeLengthFromCenter(s, i, i);
            if (s.charAt(i) == s.charAt(i + 1)) {
                len = Math.max(len, palindromeLengthFromCenter(s, i, i + 1));
            }
            if (len > maxLen) {
                maxLen = len;
                startIndex = i - (maxLen - 1) / 2;
            }
        }
        return s.substring(startIndex, startIndex + maxLen);
    }

    private int palindromeLengthFromCenter(String s, int left, int right) {
        while (left - 1 >= 0 && right + 1 < s.length() && s.charAt(left - 1) == s.charAt(right + 1)) {
            left--;
            right++;
        }
        return right - left + 1;
    }
}
