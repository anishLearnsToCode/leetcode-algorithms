// https://leetcode.com/problems/semi-ordered-permutation
// T: O(N)
// S: O(1)

import java.util.Arrays;

public class SemiOrderedPermutation {
    public int semiOrderedPermutation(int[] nums) {
        final int startIndex = findIndexOf(nums, 1);
        final int endIndex = findIndexOf(nums, nums.length);
        final int endDrift = nums.length - endIndex - 1;

        if (endIndex < startIndex) {
            return startIndex + endDrift - 1;
        }
        return startIndex + endDrift;
    }

    private int findIndexOf(int[] array, int element) {
        for (int i = 0 ; i < array.length ; i++) {
            if (array[i] == element) return i;
        }
        return -1;
    }
}
