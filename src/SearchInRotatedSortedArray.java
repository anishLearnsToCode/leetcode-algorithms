// https://leetcode.com/problems/search-in-rotated-sorted-array
// T: O(logN)
// S: O(1)

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        final int pivotIndex = binarySearchPivotIndex(nums);
        final int answer = binarySearch(nums, 0, pivotIndex - 1, target);
        if (answer != -1) {
            return answer;
        }
        return binarySearch(nums, pivotIndex, nums.length - 1, target);
    }

    private static int binarySearchPivotIndex(int[] array) {
        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] > array[array.length - 1]) left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }

    private static int binarySearch(int[] array, int start, int end, int x) {
        int left = start, right = end, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] == x) return middle;
            else if (array[middle] < x) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }
}
