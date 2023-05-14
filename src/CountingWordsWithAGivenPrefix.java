public class CountingWordsWithAGivenPrefix {
    public int prefixCount(String[] words, String prefix) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(prefix)) count++;
        }
        return count;
    }
}
