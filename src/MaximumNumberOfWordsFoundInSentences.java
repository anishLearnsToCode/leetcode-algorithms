// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences
// T: O(s * |s|)
// S: O(1)
// s = no. of sentences and |s| length of sentence

public class MaximumNumberOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        for (String sentence : sentences) {
            maxWords = Math.max(maxWords, totalWords(sentence));
        }
        return maxWords;
    }

    private int totalWords(String string) {
        int count = 0;
        for (int i = 0 ; i < string.length() ; i++) {
            if (string.charAt(i) == ' ') count++;
        }
        return count + 1;
    }
}
