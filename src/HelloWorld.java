public class HelloWorld {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[] {-1, -1};
        }

        return new int[] {
                leftBinarySearch(nums, target),
                rightBinarySearch(nums, target)
        };
    }

    private static int leftBinarySearch(int[] array, int x) {
        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] == x) {
                if (middle - 1 >= 0 && array[middle - 1] == x) {
                    right = middle - 1;
                } else return middle;
            }
            else if (array[middle] < x) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }

    private static int rightBinarySearch(int[] array, int x) {
        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] == x) {
                if (middle + 1 < array.length && array[middle + 1] == x) {
                    left = middle + 1;
                } else return middle;
            }
            else if (array[middle] < x) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }
}
