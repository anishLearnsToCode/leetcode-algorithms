// https://leetcode.com/problems/keep-multiplying-found-values-by-two
// T: O(N)
// S: O(N)

import java.util.HashSet;
import java.util.Set;

public class KeepMultiplyingFoundValuesByTwo {
    public int findFinalValue(int[] nums, int original) {
        final Set<Integer> numbers = setFrom(nums);
        while (numbers.contains(original)) {
            original *= 2;
        }
        return original;
    }

    private Set<Integer> setFrom(int[] numbers) {
        final Set<Integer> set = new HashSet<>();
        for (int element : numbers) {
            set.add(element);
        }
        return set;
    }
}
