// https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/submissions
// T:(n)
// S: O(n)

public class ReplaceAllToAvoidConsecutiveRepeatingCharacters {
    private static final Character QUESTION_MARK = '?';

    public String modifyString(String s) {
        final StringBuilder result = new StringBuilder();
        char last = QUESTION_MARK;
        for (int index = 0 ; index < s.length() ; index++) {
            char c = s.charAt(index);
            if (c == QUESTION_MARK) {
                char left = get(s, index - 1);
                if (left == QUESTION_MARK) left = last;
                final char right = get(s, index + 1);
                c = 'a';
                while (c == left || c == right) c++;
                last = c;
            }
            result.append(c);
        }
        return result.toString();
    }

    private char get(String string, int index) {
        if (index < 0 || index >= string.length()) return QUESTION_MARK;
        return string.charAt(index);
    }
}
