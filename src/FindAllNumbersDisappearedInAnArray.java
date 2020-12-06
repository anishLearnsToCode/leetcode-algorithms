// Problem Number: 448
// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> numbers = uniqueNumbersFrom(nums);
        List<Integer> result = new ArrayList<>();
        for (int i = 1 ; i <= nums.length ; i++) {
            if (!numbers.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private Set<Integer> uniqueNumbersFrom(int[] array) {
        Set<Integer> result = new HashSet<>();
        for (int number : array) {
            result.add(number);
        }
        return result;
    }
}
