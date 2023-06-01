// https://leetcode.com/problems/odd-string-difference
// T: O(|words| * |words[i]|)
// S: O(|words[i]|)

import java.util.Arrays;

public class OddStringDifference {
    public String oddString(String[] words) {
        final int[] diff1 = stringDiffArray(words[0]);
        final int[] diff2 = stringDiffArray(words[1]);

        if (Arrays.equals(diff1, diff2)) {
            for (int index = 2 ; index < words.length ; index++) {
                final int[] diff = stringDiffArray(words[index]);
                if (!Arrays.equals(diff1, diff)) return words[index];
            }
        } else {
            final int[] diff3 = stringDiffArray(words[2]);
            if (Arrays.equals(diff1, diff3)) return words[1];
            return words[0];
        }

        return words[0];
    }

    private int[] stringDiffArray(String word) {
        final int[] array = new int[word.length() - 1];
        for (int index = 0 ; index < word.length() - 1 ; index++) {
            array[index] = word.charAt(index) - word.charAt(index + 1);
        }
        return array;
    }
}
