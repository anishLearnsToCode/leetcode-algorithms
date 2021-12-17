// https://leetcode.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times
// T: O(nm^2k)
// s: O(1)

public class DetectPatternOfLengthMRepeatedKOrMoreTimes {
    public boolean containsPattern(int[] arr, int m, int k) {
        if (m * k > arr.length || m > arr.length) return false;
        if (k == 1) return true;

        for (int i = 0 ; i < arr.length - m * k + 1 ; i++) {
            if (consistsOfPattern(arr, i, m, k)) {
                return true;
            }
        }
        return false;
    }

    private boolean consistsOfPattern(int[] array, int startIndex, int patternLen, int k) {
        for (int j = startIndex + patternLen ; j <= startIndex + (k - 1) * patternLen ; j += patternLen) {
            if (!arrayIsSame(array, startIndex, j, patternLen)) {
                return false;
            }
        }
        return true;
    }

    private boolean arrayIsSame(int[] array, int i, int j, int patternLen) {
        for (int k = 0 ; k < patternLen ; k++) {
            if (array[i + k] != array[j + k]) {
                return false;
            }
        }
        return true;
    }
}
