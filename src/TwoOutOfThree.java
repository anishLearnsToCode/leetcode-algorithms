// https://leetcode.com/problems/two-out-of-three
// T: O(|nums1| + |nums2| + |nums3|)
// S: O(|nums1| + |nums2| + |nums3|)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoOutOfThree {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        final Set<Integer> set1 = getElements(nums1);
        final Set<Integer> set2 = getElements(nums2);
        final Set<Integer> set3 = getElements(nums3);
        final Set<Integer> resultElements = new HashSet<>();
        for (int element : set1) {
            if (set2.contains(element) || set3.contains(element)) {
                resultElements.add(element);
            }
        }
        for (int element : set2) {
            if (set3.contains(element)) resultElements.add(element);
        }
//        return resultElements.stream().toList();  // cant be used because LeetCode is still on a previous version of Java
        return new ArrayList<>(resultElements);
    }

    private Set<Integer> getElements(int[] array) {
        final Set<Integer> set = new HashSet<>();
        for (int element : array) {
            set.add(element);
        }
        return set;
    }
}
