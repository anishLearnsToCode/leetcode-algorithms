// https://leetcode.com/problems/check-if-strings-can-be-made-equal-with-operations-i
// T: O(N)
// S: O(1)

public class CheckIfStringsCanBeMadeEqualWithOperationsI {
    public boolean canBeEqual(String s1, String s2) {
        for (int i = 0 ; i < s1.length() - 2 ; i++) {
            if (
                    (s1.charAt(i) == s2.charAt(i) && s1.charAt(i + 2) == s2.charAt(i + 2) ||
                            (s1.charAt(i) == s2.charAt(i + 2) && s1.charAt(i + 2) == s2.charAt(i)))) {
                continue;
            }
            return false;
        }
        return true;
    }
}
