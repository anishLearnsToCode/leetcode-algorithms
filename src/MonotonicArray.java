public class MonotonicArray {
    public boolean isMonotonic(int[] nums) {
        return isMonotonicIncreasing(nums) || isMonotonicDecreasing(nums);
    }

    private boolean isMonotonicIncreasing(int[] array) {
        for (int i = 1 ; i < array.length ; i++) {
            if (array[i] < array[i - 1]) return false;
        }
        return true;
    }

    private boolean isMonotonicDecreasing(int[] array) {
        for (int i = 1 ; i < array.length ; i++) {
            if (array[i] > array[i - 1]) return false;
        }
        return true;
    }
}
