import java.util.ArrayList;
import java.util.List;

public class RearrangeSpacesBetweenWords {
    public String reorderSpaces(String text) {
        final int totalSpaces = countSpaces(text);
        final List<StringBuilder> words = getWords(text);
        final int spaces = words.size() > 1 ? totalSpaces / (words.size() - 1) : 0;
        final int extraSpaces = words.size() > 1 ? totalSpaces % (words.size() - 1) : totalSpaces;
        final StringBuilder result = new StringBuilder();
        final String spacesAfterWord = " ".repeat(spaces);
        for (int i = 0 ; i < words.size() ; i++) {
            result.append(words.get(i)).append(i != words.size() -1 ? spacesAfterWord : "");
        }
        return result.append(" ".repeat(extraSpaces)).toString();
    }

    private int countSpaces(String s) {
        int spaces = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == ' ') spaces++;
        }
        return spaces;
    }

    private List<StringBuilder> getWords(String string) {
        final List<StringBuilder> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0 ; i < string.length() ; i++) {
            if (string.charAt(i) == ' ') {
                if (word.length() > 0) words.add(word);
                word = new StringBuilder();
            } else {
                word.append(string.charAt(i));
            }
        }
        if (word.length() > 0) words.add(word);
        return words;
    }
}
