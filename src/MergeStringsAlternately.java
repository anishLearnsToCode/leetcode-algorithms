public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        final StringBuilder result = new StringBuilder();
        final String[] words = {word1, word2};
        int i = 0, maxLen = Math.max(word1.length(), word2.length());
        for (int[] indexes = {0, 0} ; indexes[0] < maxLen || indexes[1] < maxLen ; i ^= 1) {
            result.append(get(words[i], indexes[i]));
            indexes[i]++;
        }
        return result.toString();
    }

    private String get(String s, int index) {
        if (index < s.length()) return s.charAt(index) + "";
        return "";
    }
}
