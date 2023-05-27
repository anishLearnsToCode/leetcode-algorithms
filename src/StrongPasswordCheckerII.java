// https://leetcode.com/problems/strong-password-checker-ii
// T: O(|password|)
// S: O(1)

import java.util.HashSet;
import java.util.Set;

public class StrongPasswordCheckerII {
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-+";

    public boolean strongPasswordCheckerII(String password) {
        return atLeastLen8(password)
                && atLeast1LowercaseLetter(password)
                && atLeast1UppercaseLetter(password)
                && atLeast1Digit(password)
                && atLeast1SpecialCharacter(password)
                && noAdjacentSameCharacters(password);
    }

    private boolean noAdjacentSameCharacters(String password) {
        for (int i = 1 ; i < password.length() ; i++) {
            if (password.charAt(i - 1) == password.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean atLeast1SpecialCharacter(String password) {
        final Set<Character> characters = charactersOf(password);
        for (int i = 0 ; i < SPECIAL_CHARACTERS.length() ; i++) {
            if (characters.contains(SPECIAL_CHARACTERS.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private Set<Character> charactersOf(String password) {
        final Set<Character> set = new HashSet<>();
        for (int i = 0 ; i < password.length() ; i++) {
            set.add(password.charAt(i));
        }
        return set;
    }

    private boolean atLeast1Digit(String password) {
        for (int i = 0 ; i < password.length() ; i++) {
            if (password.charAt(i) >= '0' && password.charAt(i) <= '9') {
                return true;
            }
        }
        return false;
    }

    private boolean atLeast1UppercaseLetter(String password) {
        for (int i = 0 ; i < password.length() ; i++) {
            if (password.charAt(i) >= 'A' && password.charAt(i) <= 'Z') {
                return true;
            }
        }
        return false;
    }

    private boolean atLeast1LowercaseLetter(String password) {
        for (int i = 0 ; i < password.length() ; i++) {
            if (password.charAt(i) >= 'a' && password.charAt(i) <= 'z') {
                return true;
            }
        }
        return false;
    }

    private boolean atLeastLen8(String password) {
        return password.length() >= 8;
    }
}
