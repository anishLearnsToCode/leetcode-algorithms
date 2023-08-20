// https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words
// T: O(N)
// S: O(1)

import java.util.List;

public class CheckIfAStringIsAnAcronymOfWords {
    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) {
            return false;
        }

        for (int i = 0 ; i < words.size() ; i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
