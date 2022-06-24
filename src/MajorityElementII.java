// https://leetcode.com/problems/majority-element-ii
// T: O(N)
// S: O(1)

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0, candidate2 = 0, frequency1 = 0, frequency2 = 0;
        for (int element : nums) {
            if (element == candidate1) frequency1++;
            else if (element == candidate2) frequency2++;
            else if (frequency1 == 0) {
                candidate1 = element;
                frequency1 = 1;
            } else if (frequency2 == 0) {
                candidate2 = element;
                frequency2 = 1;
            } else {
                frequency1--;
                frequency2--;
            }
        }
        return confirmCandidates(nums, candidate1, candidate2);
    }

    private List<Integer> confirmCandidates(int[] array, int candidate1, int candidate2) {
        final List<Integer> result = new ArrayList<>();
        if (frequency(array, candidate1) > array.length / 3) result.add(candidate1);
        if (candidate2 != candidate1 && frequency(array, candidate2) > array.length / 3) result.add(candidate2);
        return result;
    }

    private int frequency(int[] array, int val) {
        int count = 0;
        for (int element : array) {
            if (element == val) count++;
        }
        return count;
    }
}
