// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
// T: O(logN)
// S: O(1)

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        return new int[] {
                leftMostIndex(nums, target),
                rightMostIndex(nums, target)
        };
    }

    private int leftMostIndex(int[] array, int target) {
        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] == target) {
                if (middle - 1 >= 0 && array[middle - 1] == target) right = middle - 1;
                else return middle;
            } else if (array[middle] > target) right = middle - 1;
            else left = middle + 1;
        }
        return -1;
    }

    private int rightMostIndex(int[] array, int target) {
        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] == target) {
                if (middle + 1 < array.length && array[middle + 1] == target) left = middle + 1;
                else return middle;
            } else if (array[middle] > target) right = middle - 1;
            else left = middle + 1;
        }
        return -1;
    }
}
