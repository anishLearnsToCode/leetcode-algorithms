// https://leetcode.com/problems/find-peak-element
// T: O(log(N))
// S: O(1)

public class FindPeakElement {
    public static int findPeakElement(int[] array) {
        for (int left = 0, right = array.length - 1, middle ; left <= right ; ) {
            middle = left + (right - left) / 2;

            if (isPeakElement(array, middle)) return middle;

            if (isOnIncreasingSlope(array, middle)) left = middle + 1;
            else right = middle - 1;
        }
        return -1;
    }

    private static boolean isOnIncreasingSlope(int[] array, int index) {
        return ((index > 0 && array[index - 1] < array[index]) || index == 0)
                && ((index + 1 < array.length && array[index] < array[index + 1]) || index == array.length - 1);
    }

    private static boolean isPeakElement(int[] array, int index) {
        return ((index > 0 && array[index - 1] < array[index]) || index == 0)
            && ((index + 1 < array.length && array[index + 1] < array[index]) || index == array.length - 1);
    }
}
