// https://leetcode.com/problems/maximum-length-substring-with-two-occurrences
// T: O(N)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class MaximumLengthSubstringWithTwoOccurrences {
    public int maximumLengthSubstring(String s) {
        final Map<Character, Integer> frequencies = new HashMap<>();
        int maxLength = 1;

        for (int left = 0, right = 0 ; left < s.length() && right < s.length() ; ) {
            if (frequencies.getOrDefault(s.charAt(right), 0) == 2) {
                frequencies.put(s.charAt(left), frequencies.get(s.charAt(left)) - 1);
                left++;
            } else {
                frequencies.put(s.charAt(right), frequencies.getOrDefault(s.charAt(right), 0) + 1);
                right++;
                maxLength = Math.max(maxLength, right - left);
            }
        }

        return maxLength;
    }
}
