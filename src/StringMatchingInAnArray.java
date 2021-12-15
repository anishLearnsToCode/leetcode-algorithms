import java.util.ArrayList;
import java.util.List;

public class StringMatchingInAnArray {
    public List<String> stringMatching(String[] words) {
        final List<String> result = new ArrayList<>();
        for (int i = 0 ; i < words.length ; i++) {
            for (int j = 0 ; j < words.length ; j++) {
                if(i == j) continue;
                if (isSubString(words[i], words[j])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    private boolean isSubString(String pattern, String text) {
        if (pattern.length() > text.length()) return false;
        if (pattern.length() == text.length()) return pattern.equals(text);
        return text.contains(pattern);
    }
}
