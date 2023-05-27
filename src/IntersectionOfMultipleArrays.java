// https://leetcode.com/problems/intersection-of-multiple-arrays
// T: O()
// S: O()

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfMultipleArrays {
    public List<Integer> intersection(int[][] nums) {
        Set<Integer> set = setFrom(nums[0]);
        for (int index = 1 ; index < nums.length ; index++) {
            final Set<Integer> other = setFrom(nums[index]);
            set = intersection(set, other);
        }
        final List<Integer> list = toList(set);
        list.sort(Integer::compareTo);
        return list;
    }

    private Set<Integer> setFrom(int[] array) {
        final Set<Integer> set = new HashSet<>();
        for (int element : array) {
            set.add(element);
        }
        return set;
    }

    private List<Integer> toList(final Set<Integer> set) {
        return new ArrayList<>(set);
    }

    private Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        final Set<Integer> result = new HashSet<>();
        for (int element : set1) {
            if (set2.contains(element)) result.add(element);
        }
        return result;
    }
}
