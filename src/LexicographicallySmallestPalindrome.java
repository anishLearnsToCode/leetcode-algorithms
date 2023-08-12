// https://leetcode.com/problems/lexicographically-smallest-palindrome
// T: O(N)
// S: O(N)

public class LexicographicallySmallestPalindrome {
    public String makeSmallestPalindrome(String s) {
        final StringBuilder firstPart = new StringBuilder();
        final StringBuilder lastPart = new StringBuilder();

        for (int i = 0 ; i < s.length() / 2 ; i++) {
            char first = s.charAt(i), last = s.charAt(s.length() - 1 - i);
            if (first != last) {
                char smaller = (char) Math.min(first, last);
                firstPart.append(smaller);
                lastPart.append(smaller);
            } else {
                firstPart.append(first);
                lastPart.append(first);
            }
        }

        if (s.length() % 2 == 0) {
            return firstPart.append(lastPart.reverse()).toString();
        }
        return firstPart.append(s.charAt(s.length() / 2)).append(lastPart.reverse()).toString();
    }
}
