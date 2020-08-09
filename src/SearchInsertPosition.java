public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        return binarySearchNextLargest(nums, target);
    }

    private int binarySearchNextLargest(int[] array, int val) {
        if (array == null || array.length == 0) return 0;

        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] == val) return middle;
            else if (array[middle] > val) right = middle - 1;
            else left = middle + 1;
        }

        return left;
    }
}
