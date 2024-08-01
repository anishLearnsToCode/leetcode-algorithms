// https://leetcode.com/problems/find-peak-element
// T: O(log(N))
// S: O(1)

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (isPeak(nums, middle)) return middle;
            else if (middle +  1 < nums.length && nums[middle] < nums[middle + 1]) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }

    private static boolean isPeak(int[] array, int x) {
        return (x - 1 < 0 || array[x - 1] < array[x])
                && (x + 1 >= array.length || array[x] > array[x + 1]);
    }
}
