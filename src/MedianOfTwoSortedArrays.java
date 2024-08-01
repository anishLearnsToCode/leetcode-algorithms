// https://leetcode.com/problems/median-of-two-sorted-arrays

public class MedianOfTwoSortedArrays {
    static public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int[] array = merge(nums1, nums2);
        if (array.length % 2 == 1) {
            return array[array.length / 2];
        }
        return ((double) array[array.length / 2 - 1] + array[array.length / 2]) / 2;
    }

    private static int[] merge(int[] array1, int[] array2) {
        final int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;

        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }

        while (i < array1.length) {
            result[k++] = array1[i++];
        }

        while (j < array2.length) {
            result[k++] = array2[j++];
        }

        return result;
    }
}
