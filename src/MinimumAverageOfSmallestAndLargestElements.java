// https://leetcode.com/problems/minimum-average-of-smallest-and-largest-elements
// T: O(N log(N))
// S: O(log(N))

import java.util.Arrays;

public class MinimumAverageOfSmallestAndLargestElements {
    public double minimumAverage(int[] array) {
        Arrays.sort(array);
        double minAverage = Double.MAX_VALUE;

        for (int i = 0 ; i < array.length / 2 ; i++) {
            minAverage = Math.min(minAverage, ((double) array[i] + array[array.length - i - 1]) / 2);
        }

        return minAverage;
    }
}
