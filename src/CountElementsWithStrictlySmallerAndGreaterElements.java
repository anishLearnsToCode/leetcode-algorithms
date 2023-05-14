// https://leetcode.com/problems/count-elements-with-strictly-smaller-and-greater-elements
// T: O(n log(n))
// S: O(log(n))

import java.util.Arrays;

public class CountElementsWithStrictlySmallerAndGreaterElements {
    public int countElements(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int index = 1 ; index < nums.length - 1 ; index++) {
            if (nums[0] != nums[index] && nums[index] != nums[nums.length - 1]) count++;
        }
        return count;
    }
}
