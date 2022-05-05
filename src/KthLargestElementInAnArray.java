// https://leetcode.com/problems/kth-largest-element-in-an-array
// T: O(n)
// S: O(1)

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int partitionIndex = nums.length - k;
        for (int left = 0, right = nums.length - 1, j ; left < right ; ) {
            j = partition(nums, left, right);
            if (j == partitionIndex) return nums[partitionIndex];
            else if (j < partitionIndex) left = j + 1;
            else right = j - 1;
        }
        return nums[partitionIndex];
    }

    private int partition(int[] array, int left, int right) {
        int pivot = array[right], i = left - 1;
        for (int j = left ; j < right ; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
