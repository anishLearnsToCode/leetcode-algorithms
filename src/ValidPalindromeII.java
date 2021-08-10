public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left < right ; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                if (isValidPalindrome(s, left + 1, right)) return true;
                return isValidPalindrome(s, left, right + 1);
            }
        }
        return true;
    }

    private boolean isValidPalindrome(String string, int left, int right) {
        if (left >= string.length() || right <= 0) return false;
        for ( ; left < right ; left++, right--) {
            if (string.charAt(left) != string.charAt(right)) return false;
        }
        return true;
    }
}
