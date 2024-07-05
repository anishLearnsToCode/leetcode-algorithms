// https://leetcode.com/problems/minimum-right-shifts-to-sort-the-array
// T: O(N)
// S: O(1)

import java.util.List;

public class MinimumRightShiftsToSortTheArray {
    public int minimumRightShifts(List<Integer> array) {
        final int minElementIndex = getMinElementIndex(array);
        if (!canSort(array, minElementIndex)) {
            return -1;
        }

        return (array.size() - minElementIndex) % array.size();
    }

    private static boolean canSort(List<Integer> array, int minElementIndex) {
        for (int i = (minElementIndex + 1) % array.size(), k = 0 ; k < array.size() - 1; k++, i = (i + 1) % array.size()) {
            if (array.get(i) <= array.get((i - 1 + array.size()) % array.size())) {
                return false;
            }
        }
        return true;
    }

    private static int getMinElementIndex(List<Integer> array) {
        int minElement = Integer.MAX_VALUE, index = -1;
        for (int i = 0 ; i < array.size() ; i++) {
            if (array.get(i) < minElement) {
                minElement = array.get(i);
                index = i;
            }
        }
        return index;
    }
}
