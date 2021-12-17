// https://leetcode.com/problems/mean-of-array-after-removing-some-elements
// T: O(nlog(n))
// S: O(1)

import java.util.Arrays;

public class MeanOfArrayAfterRemovingSomeElements {
    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        final int startIndex = arr.length / 20;
        final int endIndex = arr.length - startIndex;
        for (int index = startIndex ; index < endIndex; index++) {
            sum += arr[index];
        }
        return (double) sum / (endIndex - startIndex);
    }
}
