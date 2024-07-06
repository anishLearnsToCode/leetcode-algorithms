// https://leetcode.com/problems/make-three-strings-equal
// T: O(min(|s1|, |s2|, |s3|))
// S: O(1)

public class MakeThreeStringsEqual {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int maxPrefixLength = 0;
        for (int i = 0, j = 0, k = 0 ; i < s1.length() && j < s2.length() && k < s3.length() ; i++, j++, k++) {
            if (s1.charAt(i) != s2.charAt(j) || s2.charAt(j) != s3.charAt(k)) {
                break;
            }
            maxPrefixLength++;
        }

        if (maxPrefixLength == 0) {
            return -1;
        }

        return s1.length() + s2.length() + s3.length() - 3 * maxPrefixLength;
    }
}
