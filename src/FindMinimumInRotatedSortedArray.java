// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
// T: O(log(N))
// T: O(1)

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] array) {
        if (!isRotated(array)) return array[0];

        for (int left = 0, right = array.length - 1 ; left <= right ; ) {
            int middle = left + (right - left) / 2;
            if (array[middle] > array[middle + 1]) return array[middle + 1];
            if (array[middle] < array[middle - 1]) return array[middle];

            if (array[middle] < array[array.length - 1]) right = middle - 1;
            else left = middle + 1;
        }
        return -1;
    }

    private boolean isRotated(int[] array) {
        return array[0] > array[array.length - 1];
    }
}
