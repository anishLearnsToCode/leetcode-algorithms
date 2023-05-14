// https://leetcode.com/problems/find-the-difference-of-two-arrays
// T: O(N + M)
// S: O(N + M)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        final Set<Integer> numbers1 = getSetFrom(nums1);
        final Set<Integer> numbers2 = getSetFrom(nums2);
        final List<Integer> distinctElementsInNums1 = difference(numbers1, numbers2);
        final List<Integer> distinctElementsInNums2 = difference(numbers2, numbers1);

        return List.of(distinctElementsInNums1, distinctElementsInNums2);
    }

    private Set<Integer> getSetFrom(int[] array) {
        final Set<Integer> set = new HashSet<>();
        for (int element : array) {
            set.add(element);
        }
        return set;
    }

    private List<Integer> difference(Set<Integer> set1, Set<Integer> set2) {
        final List<Integer> result = new ArrayList<>();
        for (int element : set1) {
            if (!set2.contains(element)) result.add(element);
        }
        return result;
    }
}
