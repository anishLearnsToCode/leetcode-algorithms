// https://leetcode.com/problems/split-strings-by-separator
// W: number of words
// s: string in words
// T: O(W * |s|)
// S: O(W * |s|)

import java.util.ArrayList;
import java.util.List;

public class SplitStringsBySeparator {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        final List<String> result = new ArrayList<>();
        for (String word : words) {
            final List<String> splitStrings = split(word, separator);
            for (String split : splitStrings) {
                if (!split.isEmpty()) {
                    result.add(split);
                }
            }
        }
        return result;
    }

    private List<String> split(String string, char separator) {
        final List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < string.length() ; i++) {
            if (string.charAt(i) == separator) {
                result.add(builder.toString());
                builder = new StringBuilder();
            } else {
                builder.append(string.charAt(i));
            }
        }
        if (!builder.isEmpty()) {
            result.add(builder.toString());
        }
        return result;
    }
}
