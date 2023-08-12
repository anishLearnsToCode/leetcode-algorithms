// https://leetcode.com/problems/minimize-string-length
// T: O(N)
// S: O(1)

import java.util.HashSet;
import java.util.Set;

public class MinimizeStringLength {
    public int minimizedStringLength(String s) {
        final Set<Character> letters = new HashSet<>();
        for (int i = 0 ; i < s.length() ; i++) {
            letters.add(s.charAt(i));
        }
        return letters.size();
    }
}
