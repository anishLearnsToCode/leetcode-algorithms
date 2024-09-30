// https://leetcode.com/problems/shortest-word-distance
// N: number of words, M: average word length
// T: O(N * M)
// S: O(1)

public class ShortestWordDistance {
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int result = wordsDict.length, i = -1, j = -1;
        for (int index = 0 ; index < wordsDict.length ; index++) {
            if (wordsDict[index].equals(word1)) {
                i = index;
            } else if (wordsDict[index].equals(word2)) {
                j = index;
            }

            if (i != -1 && j != -1) {
                result = Math.min(result, Math.abs(j - i));
            }
        }
        return result;
    }
}
