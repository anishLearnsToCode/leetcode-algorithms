// https://leetcode.com/problems/number-of-valid-words-in-a-sentence
// T: O(|sentence|)
// S: O(|sentence|)

import java.util.Set;

public class NumberOfValidWordsInASentence {
    private static final Set<Character> PUNCTUATIONS = Set.of('!', '.', ',');

    public int countValidWords(String sentence) {
        StringBuilder word = new StringBuilder();
        int validWords= 0;
        for (int i = 0 ; i < sentence.length() ; i++) {
            if (sentence.charAt(i) == ' ') {
                validWords += isValidWord(word) ? 1 : 0;
                word = new StringBuilder();
            } else word.append(sentence.charAt(i));
        }
        return validWords + (isValidWord(word) ? 1 : 0);
    }

    private boolean isValidWord(StringBuilder s) {
        if (s.length() == 0) return false;
        for (int i = 0, hyphens = 0 ; i < s.length() ; i++) {
            if (isDigit(s.charAt(i))) return false;
            else if (isHyphen(s.charAt(i))) {
                if (hyphens > 0) return false;
                hyphens++;
                if (i == 0 || i == s.length() - 1 || !isAlphabet(s.charAt(i + 1))) return false;
            } else if (isPunctuationMark(s.charAt(i)) && i < s.length() - 1) return false;
        }
        return true;
    }

    private boolean isDigit(char c) {
        return Character.isDigit(c);
    }

    private boolean isHyphen(char c) {
        return c == '-';
    }

    private boolean isAlphabet(char c) {
        return Character.isAlphabetic(c);
    }

    private boolean isPunctuationMark(char c) {
        return PUNCTUATIONS.contains(c);
    }
}
