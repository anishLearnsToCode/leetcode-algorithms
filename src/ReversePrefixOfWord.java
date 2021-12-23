// https://leetcode.com/problems/reverse-prefix-of-word
// T: O(|word|)
// S: O(|word|)

public class ReversePrefixOfWord {
    public String reversePrefix(String word, char ch) {
        final StringBuilder result = new StringBuilder();
        boolean encounteredChar = false;
        for (int i = 0 ; i < word.length() ; i++) {
            if (!encounteredChar && word.charAt(i) == ch) {
                result.append(word.charAt(i)).reverse();
                encounteredChar = true;
            } else {
                result.append(word.charAt(i));
            }
        }
        return result.toString();
    }
}
