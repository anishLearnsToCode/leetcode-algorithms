// https://leetcode.com/problems/greatest-english-letter-in-upper-and-lower-case
// T: O(|s|)
// S: O(1)

import java.util.HashSet;
import java.util.Set;

public class GreatestEnglishLetterInUpperAndLowerCase {
    public String greatestLetter(String s) {
        final Set<Character> lowercaseLetters = getLowercaseLetters(s);
        final Set<Character> uppercaseLetters = getUppercaseLetters(s);
        char maxLetter = 'a' - 1;

        for (char letter : lowercaseLetters) {
            if (uppercaseLetters.contains(Character.toUpperCase(letter)) && letter > maxLetter) {
                maxLetter = letter;
            }
        }

        return maxLetter >= 'a' ? (Character.toUpperCase(maxLetter) + "") : "";
    }

    private Set<Character> getUppercaseLetters(String string) {
        final Set<Character> set = new HashSet<>();
        for (int i = 0 ; i < string.length() ; i++) {
            if (Character.isUpperCase(string.charAt(i))) {
                set.add(string.charAt(i));
            }
        }
        return set;
    }

    private Set<Character> getLowercaseLetters(String string) {
        final Set<Character> set = new HashSet<>();
        for (int i = 0 ; i < string.length() ; i++) {
            if (Character.isLowerCase(string.charAt(i))) {
                set.add(string.charAt(i));
            }
        }
        return set;
    }
}
