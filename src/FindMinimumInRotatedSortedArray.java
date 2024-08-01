// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
// T: O(log(N))
// T: O(1)

public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return nums[binarySearchPivotIndex(nums)];
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
}
