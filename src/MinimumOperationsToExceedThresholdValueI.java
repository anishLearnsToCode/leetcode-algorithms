// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-i
// T: O(N log(N))
// S: O(log(N))

import java.util.Arrays;

public class MinimumOperationsToExceedThresholdValueI {
    public int minOperations(int[] array, int k) {
        Arrays.sort(array);
        return binarySearch(array, k);
    }

    // binary search with left drag
    private static int binarySearch(int[] array, int element) {
        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] == element) right = middle - 1;
            else if (array[middle] <= element) left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }
}
