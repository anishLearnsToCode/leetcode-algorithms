// https://leetcode.com/problems/number-of-changing-keys
// T: O(|s|)
// S: O(1)

public class NumberOfChangingKeys {
    public int countKeyChanges(String s) {
        int changes = 0;
        for (int i = 1 ; i < s.length() ; i++) {
            if (isDifferent(s.charAt(i - 1), s.charAt(i))) {
                changes++;
            }
        }
        return changes;
    }

    private static boolean isDifferent(char a, char b) {
        return Character.toLowerCase(a) != Character.toLowerCase(b);
    }
}
