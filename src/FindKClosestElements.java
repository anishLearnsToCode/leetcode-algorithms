// https://leetcode.com/problems/find-k-closest-elements
// T: O(logN + KLogK)
// S: O(logK)

import java.util.ArrayList;
import java.util.List;

public class FindKClosestElements {
    public static List<Integer> findClosestElements(int[] array, int k, int x) {
        final int index = binarySearch(array, x);
        final List<Integer> result = new ArrayList<>();

        for (int left = index - 1, right = index ; k > 0 ; k--) {
            if (left == -1) {
                result.add(array[right++]);
            } else if (right == array.length) {
                result.add(array[left--]);
            } else {
                if (Math.abs(array[left] - x) <= Math.abs(array[right] - x)) {
                    result.add(array[left--]);
                } else {
                    result.add(array[right++]);
                }
            }
        }

        result.sort(Integer::compareTo);
        return result;
    }

    private static int binarySearch(int[] array, int x) {
        int left = 0, right = array.length - 1, middle;
        while (left <= right) {
            middle = left + (right - left) / 2;
            if (array[middle] == x) return middle;
            else if (array[middle] < x) left = middle + 1;
            else right = middle - 1;
        }
        return left;
    }
}
