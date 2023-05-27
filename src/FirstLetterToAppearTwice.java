// https://leetcode.com/problems/first-letter-to-appear-twice
// T: O(1)
// S: O(1)

import java.util.HashSet;
import java.util.Set;

public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        final Set<Character> characters = new HashSet<>();
        for (int index = 0 ; index < s.length() ; index++) {
            if (characters.contains(s.charAt(index))) {
                return s.charAt(index);
            }
            characters.add(s.charAt(index));
        }
        return 'a';
    }
}
