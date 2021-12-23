// https://leetcode.com/problems/check-if-string-is-a-prefix-of-array
// T : O(|s|)
// S : O(1)

public class CheckIfStringIsAPrefixOfArray {
    public boolean isPrefixString(String s, String[] words) {
        int w = 0, j = 0;
        for (int i = 0 ; i < s.length() && w < words.length ; i++) {
            if (s.charAt(i) != words[w].charAt(j)) return false;
            if (j == words[w].length() - 1) {
                if (w == words.length - 1 && i + 1 < s.length()) return false;
                w++;
                j = 0;
            } else j++;
        }
        return j == 0;
    }
}
