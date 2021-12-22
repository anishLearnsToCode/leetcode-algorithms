import java.util.ArrayList;
import java.util.List;

public class SortingTheSentence {
    public String sortSentence(String s) {
        final List<Word> words = getWords(s);
        words.sort(Word::compareTo);
        final StringBuilder result = new StringBuilder();
        for (Word word : words) {
            result.append(word.val).append(' ');
        }
        return result.deleteCharAt(result.length() - 1).toString();
    }

    private List<Word> getWords(String s) {
        StringBuilder word = new StringBuilder();
        final List<Word> words = new ArrayList<>();
        for (int index = 0 ; index < s.length() ; index++) {
            if (Character.isDigit(s.charAt(index))){
                words.add(new Word(word.toString(), s.charAt(index) - '0'));
                word = new StringBuilder();
            } else if (s.charAt(index) != ' '){
                word.append(s.charAt(index));
            }
        }
        return words;
    }

    private static final class Word implements Comparable<Word> {
        private final String val;
        private final int position;

        private Word(String val, int position) {
            this.val = val;
            this.position = position;
        }

        @Override
        public int compareTo(Word o) {
            return Integer.compare(this.position, o.position);
        }
    }
}
