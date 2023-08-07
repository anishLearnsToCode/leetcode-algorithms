// https://leetcode.com/problems/find-the-longest-balanced-substring-of-a-binary-string
// T: O(n)
// S: O(1)

public class FindTheLongestBalancedSubstringOfABinaryString {
    public int findTheLongestBalancedSubstring(String s) {
        int result = 0;
        for (int maxZeros = 0, maxOnes = 0, i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '0') {
                if (i - 1 >= 0 && s.charAt(i - 1) == '1') {
                    result = Math.max(result, 2 * Math.min(maxOnes, maxZeros));
                    maxOnes = 0;
                    maxZeros = 1;
                } else {
                    maxZeros++;
                }
            } else {
                maxOnes++;
                if (i == s.length() - 1) {
                    result = Math.max(result, 2 * Math.min(maxOnes, maxZeros));
                }
            }
        }
        return result;
    }
}
