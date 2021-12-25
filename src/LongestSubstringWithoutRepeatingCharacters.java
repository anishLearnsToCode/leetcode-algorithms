// https://leetcode.com/problems/longest-substring-without-repeating-characters
// T: O(|s|)
// S: O(1)

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        final Set<Character> letters = new HashSet<>();
        int maxLength = 1;
        for (int i = 0, j = 0 ; i < s.length() ; i++) {
            if (letters.contains(s.charAt(i))) {
                while (letters.contains(s.charAt(i))) {
                    letters.remove(s.charAt(j++));
                }
            }
            letters.add(s.charAt(i));
            maxLength = Math.max(maxLength, i - j + 1);
        }
        return maxLength;
    }
}
