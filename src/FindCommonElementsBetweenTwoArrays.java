// https://leetcode.com/problems/find-common-elements-between-two-arrays
// m = |array1|, n = |array2|
// T: O(m + n)
// S: O(m + n)

import java.util.HashSet;
import java.util.Set;

public class FindCommonElementsBetweenTwoArrays {
    public int[] findIntersectionValues(int[] array1, int[] array2) {
        final Set<Integer> set1 = toSet(array1);
        final Set<Integer> set2 = toSet(array2);

        return new int[] { commonElements(array1, set2), commonElements(array2, set1) };
    }

    private static Set<Integer> toSet(int[] array) {
        final Set<Integer> set = new HashSet<>();
        for (int element : array) {
            set.add(element);
        }
        return set;
    }

    private static int commonElements(int[] array, Set<Integer> set) {
        int count = 0;
        for (int element : array) {
            if (set.contains(element)) {
                count++;
            }
        }
        return count;
    }
}
