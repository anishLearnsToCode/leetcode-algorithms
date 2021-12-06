import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();
        for (int fromIndex = 0 ; fromIndex < text.length() ; fromIndex += first.length() + 1) {
            fromIndex = text.indexOf(first, fromIndex);
            if (fromIndex == -1) break;
            if (areEqual(text, fromIndex + first.length() + 1, second)
                    && fromIndex + first.length() + second.length() + 2 < text.length()) {
                result.add(nextWord(text, fromIndex + first.length() + second.length() + 2));
            }
        }
        return result.toArray(new String[0]);
    }

    private boolean areEqual(String text, int fromIndex, String pattern) {
        if (pattern.length() > text.length() - fromIndex) return false;
        for (int index = fromIndex ; index < text.length() && index - fromIndex < pattern.length() ; index++) {
            if (text.charAt(index) != pattern.charAt(index - fromIndex)) return false;
        }
        return true;
    }

    private String nextWord(String text, int startIndex) {
        StringBuilder result = new StringBuilder();
        for (int index = startIndex ; index < text.length() && text.charAt(index) != ' ' ; index++) {
            result.append(text.charAt(index));
        }
        return result.toString();
    }
}
