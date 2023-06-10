// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values
// T: O(N + M)
// S: O(N + M)

import java.util.ArrayList;
import java.util.List;

public class MergeTwo2DArraysBySummingValues {
    public int[][] mergeArrays(int[][] array1, int[][] array2) {
        final List<int[]> result = new ArrayList<>();
        int i = 0, j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i][0] == array2[j][0]) {
                result.add(new int[] {array1[i][0], array1[i][1] + array2[j][1]});
                i++;
                j++;
            } else if (array1[i][0] < array2[j][0]) {
                result.add(array1[i++]);
            } else {
                result.add(array2[j++]);
            }
        }

        while (i < array1.length) {
            result.add(array1[i++]);
        }

        while (j < array2.length) {
            result.add(array2[j++]);
        }

        return toArray(result);
    }

    private int[][] toArray(List<int[]> list) {
        final int[][] array = new int[list.size()][2];
        int k = 0;
        for (int[] slice : list) {
            array[k++] = slice;
        }
        return array;
    }
}
