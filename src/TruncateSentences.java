public class TruncateSentences {
    public String truncateSentence(String s, int k) {
        final StringBuilder result = new StringBuilder();
        for (int index = 0, words = 0 ; index < s.length() && words < k ; index++) {
            if (s.charAt(index) != ' ') {
                result.append(s.charAt(index));
            } else {
                words++;
                result.append(words < k ? ' ' : "");
            }
        }
        return result.toString();
    }
}
