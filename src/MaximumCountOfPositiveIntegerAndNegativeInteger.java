// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer
// T: O(log(N))
// S: O(1)

public class MaximumCountOfPositiveIntegerAndNegativeInteger {
    public int maximumCount(int[] nums) {
        int firstIndex = binarySearchFirstIndex(nums, 0);
        int lastIndex = binarySearchLastIndex(nums, 0);
        return Math.max(firstIndex, nums.length - lastIndex - (lastIndex < nums.length && nums[lastIndex] == 0 ? 1 : 0));
    }

    // left leaning binary search with insertion point
    private int binarySearchFirstIndex(int[] array, int x) {
        int left = 0, right = array.length - 1, middle, index = -1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] == x) {
                index = middle;
                right = middle - 1;
            } else if (array[middle] > x) right = middle - 1;
            else left = middle + 1;
        }
        return index == -1 ? left : index;
    }

    // right leaning binary search with insertion point
    private int binarySearchLastIndex(int[] array, int x) {
        int left = 0, right = array.length - 1, middle, index = -1;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] == x) {
                index = middle;
                left = middle + 1;
            } else if (array[middle] > x) right = middle - 1;
            else left = middle + 1;
        }
        return index == -1 ? left : index;
    }
}
