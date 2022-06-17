// https://leetcode.com/problems/reverse-words-in-a-string
// T: O(s)
// S: O(s)

public class ReverseWordsInAString {
    private static final char SPACE = ' ';

    public static String reverseWords(String s) {
        final String[] words = s.split(" ");
        final StringBuilder result = new StringBuilder();
        for (int i = words.length - 1 ; i >= 0 ; i--) {
            String word = words[i];
            if (word.isEmpty()) continue;
            result.append(word).append(SPACE);
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
