// https://leetcode.com/problems/next-permutation
// T: O(|nums|)
// S: O(1)

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        for (int i = nums.length - 2 ; i >= 0 ; i--) {
            if (nums[i] < nums[i + 1]) {
                int index = indexOfNextLargest(nums, i + 1, nums[i]);
                swap(nums, i, index);
                reverse(nums, i + 1, nums.length);
                return;
            }
        }
        reverse(nums);
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int indexOfNextLargest(int[] array, int start, int x) {
        for (int i = start ; i < array.length ; i++) {
            if (array[i] <= x) {
                return i - 1;
            }
        }
        return array.length - 1;
    }

    private void reverse(int[] array) {
        reverse(array, 0, array.length);
    }

    private void reverse(int[] array, int start, int end) {
        for (int i = start ; i < start + (end - start) / 2 ; i++) {
            swap(array, i, end - i + start - 1);
        }
    }
}
