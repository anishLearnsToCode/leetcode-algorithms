// https://leetcode.com/problems/check-if-the-number-is-fascinating
// T: O(log(N))
// S: O(1)

import java.util.HashSet;
import java.util.Set;

public class CheckIfTheNumberIsFascinating {
    public boolean isFascinating(int number) {
        final String modifiedNumber = "" + number + (2 * number) + (3 * number);
        final Set<Character> digits = toSet(modifiedNumber);
        return digits.size() == 9 && !digits.contains('0') && modifiedNumber.length() == 9;
    }

    private Set<Character> toSet(String str) {
        final Set<Character> set = new HashSet<>();
        for (int i = 0 ; i < str.length() ; i++) {
            set.add(str.charAt(i));
        }
        return set;
    }
}
