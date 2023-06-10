// https://leetcode.com/problems/form-smallest-number-from-two-digit-arrays
// T: O(N log(N) + M log(M))
// S: O(log(N) + log(M))

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FormSmallestNumberFromTwoDigitArrays {
    public int minNumber(int[] nums1, int[] nums2) {
        final Set<Integer> intersection = intersection(nums1, nums2);

        if (!intersection.isEmpty()) {
            final int[] digits = toArray(intersection);
            Arrays.sort(digits);
            return digits[0];
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        final int smallerDigit = Math.min(nums1[0], nums2[0]);
        final int largerDigit = Math.max(nums1[0], nums2[0]);
        return smallerDigit * 10 + largerDigit;
    }

    private Set<Integer> intersection(int[] array1, int[] array2) {
        final Set<Integer> set1 = toSet(array1);
        final Set<Integer> set2 = toSet(array2);
        return intersection(set1, set2);
    }

    private Set<Integer> toSet(int[] array) {
        final Set<Integer> set = new HashSet<>();
        for (int element : array) {
            set.add(element);
        }
        return set;
    }

    private Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2) {
        final Set<Integer> set = new HashSet<>();
        for (int element : set1) {
            if (set2.contains(element)) {
                set.add(element);
            }
        }
        return set;
    }

    private int[] toArray(Set<Integer> set) {
        final int[] array = new int[set.size()];
        int index = 0;
        for (int element : set) {
            array[index++] = element;
        }
        return array;
    }
}
