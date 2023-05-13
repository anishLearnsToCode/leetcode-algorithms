// https://leetcode.com/problems/check-if-all-as-appears-before-all-bs
// T: O(|s|)
// S: O(1)

public class CheckIfAllTheAsAppearBeforeAllTheBs {
    public boolean checkString(String s) {
        boolean seenB = false;
        for (int index = 0 ; index < s.length() ; index++) {
            if (s.charAt(index) == 'b') seenB = true;
            if (s.charAt(index) == 'a' && seenB) return false;
        }
        return true;
    }
}
