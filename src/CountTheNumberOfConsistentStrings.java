// T: O(allowed + words * word)
// S: O(allowed)

import java.util.HashSet;
import java.util.Set;

public class CountTheNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        final Set<Character> allowedCharacters = getCharacters(allowed);
        int consistentStrings = 0;
        for (String word :words) {
            if (allCharsPresentIn(word, allowedCharacters)) {
                consistentStrings++;
            }
        }
        return consistentStrings;
    }

    private Set<Character> getCharacters(String string) {
        final Set<Character> set = new HashSet<>();
        for (int index = 0 ; index < string.length() ; index++) {
            set.add(string.charAt(index));
        }
        return set;
    }

    private boolean allCharsPresentIn(String string, Set<Character> allowedChars) {
        for (int index = 0 ; index < string.length() ; index++) {
            if (!allowedChars.contains(string.charAt(index))) {
                return false;
            }
        }
        return true;
    }
}
