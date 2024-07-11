// https://leetcode.com/problems/distribute-elements-into-two-arrays-i
// T: O(N)
// S: O(N)

import java.util.ArrayList;
import java.util.List;

public class DistributeElementsIntoTwoArraysI {
    public int[] resultArray(int[] array) {
        final List<Integer> array1 = new ArrayList<>();
        final List<Integer> array2 = new ArrayList<>();

        array1.add(array[0]);
        array2.add(array[1]);

        for (int i = 2 ; i < array.length ; i++) {
            if (array1.get(array1.size() - 1) > array2.get(array2.size() - 1)) {
                array1.add(array[i]);
            } else {
                array2.add(array[i]);
            }
        }

        return concatenate(array1, array2);
    }

    private static int[] concatenate(List<Integer> array1, List<Integer> array2) {
        final int[] result = new int[array1.size() + array2.size()];
        for (int i = 0 ; i < array1.size() ; i++) {
            result[i] = array1.get(i);
        }
        for (int i = 0 ; i < array2.size() ; i++) {
            result[array1.size() + i] = array2.get(i);
        }
        return result;
    }
}
