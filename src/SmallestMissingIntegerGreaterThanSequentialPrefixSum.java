// https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum
// T: O(N)
// S: O(N)

import java.util.HashSet;
import java.util.Set;

public class SmallestMissingIntegerGreaterThanSequentialPrefixSum {
    public int missingInteger(int[] array) {
        final int sequentialSum = getLongestSequentialSum(array);
        final Set<Integer> numbers = toSet(array);
        for (int start = sequentialSum ; ; start++) {
            if (!numbers.contains(start)) {
                return start;
            }
        }
    }

    private static Set<Integer> toSet(int[] array) {
        final Set<Integer> set = new HashSet<>();
        for (int element : array) {
            set.add(element);
        }
        return set;
    }

    private static int getLongestSequentialSum(int[] array) {
        int sum = array[0];
        for (int i = 1 ; i < array.length ; i++) {
            if (array[i] == array[i - 1] + 1) {
                sum += array[i];
            } else {
                break;
            }
        }
        return sum;
    }
}
