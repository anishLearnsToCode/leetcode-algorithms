// https://leetcode.com/problems/sort-even-and-odd-indices-independently
// T: O(n log(n))
// S: O(n)

import java.util.Arrays;
import java.util.Comparator;

public class SortEvenAndOddIndicesIndependently {
    public int[] sortEvenOdd(int[] nums) {
        final int[] even = new int[(nums.length + 1) / 2];
        final Integer[] odd = new Integer[nums.length / 2];

        for (int i = 0 ; i < nums.length ; i++) {
            if (i % 2 == 0) even[i / 2] = nums[i];
            else odd[i / 2] = nums[i];
        }

        Arrays.sort(even);
        Arrays.sort(odd, Comparator.reverseOrder());

        for (int i = 0 ; i < nums.length ; i++) {
            if (i % 2 == 0) nums[i] = even[i / 2];
            else nums[i] = odd[i / 2];
        }

        return nums;
    }
}
