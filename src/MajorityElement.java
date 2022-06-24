// https://leetcode.com/problems/majority-element
// T: O(N)
// S: O(1)

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int candidate = nums[0], frequency = 0;

        for (int element : nums) {
            frequency += element == candidate ? 1 : -1;

            if (frequency == 0) {
                candidate = element;
                frequency = 1;
            }
        }

        return candidate;
    }
}
