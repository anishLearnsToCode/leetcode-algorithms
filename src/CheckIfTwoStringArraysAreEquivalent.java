public class CheckIfTwoStringArraysAreEquivalent {
    public  boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        for (int w1 = 0, w2 = 0, i = 0, j = 0 ; w1 < word1.length && w2 < word2.length ; ) {
            if (word1[w1].charAt(i) != word2[w2].charAt(j)) return false;
            if (i == word1[w1].length() - 1) {
                w1++;
                i = 0;
            } else {
                i++;
            }
            if (j == word2[w2].length() - 1) {
                w2++;
                j = 0;
            } else {
                j++;
            }
            if (w1 == word1.length && w2 == word2.length) return true;
        }
        return false;
    }
}
