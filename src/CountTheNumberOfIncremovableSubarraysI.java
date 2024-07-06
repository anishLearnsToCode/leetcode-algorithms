// https://leetcode.com/problems/count-the-number-of-incremovable-subarrays-i
// T: O(N^3)
// S: O(1)

import java.util.Enumeration;

public class CountTheNumberOfIncremovableSubarraysI {
    public static int incremovableSubarrayCount(int[] array) {
        int numberIncremovableSubarrays = 0;
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = i ; j < array.length ; j++) {
                // we consider subarray [i,j] and check for array - subarray whether it is strictly
                // increasing or not
                if (isStrictlyIncreasing(array, i, j)) {
                    numberIncremovableSubarrays += array.length - (i == j ? i : j);
                    break;
                }
            }
        }

        return numberIncremovableSubarrays;
    }

    private static boolean isStrictlyIncreasing(int[] array, int i, int j) {
        for (int index = 0, previous = -1 ; index < array.length ; index++) {
            if (index == i) {
                index = j;
                continue;
            }
            if (previous == -1) {
                previous = array[index];
                continue;
            }
            if (array[index] <= previous) {
                return false;
            }
            previous = array[index];
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(incremovableSubarrayCount(new int[] { 1, 2, 3, 4 }));
    }
}
