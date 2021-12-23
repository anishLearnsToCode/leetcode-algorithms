// https://leetcode.com/problems/find-the-middle-index-in-array
// T: O(N)
// S: O(1)

import java.util.Arrays;

public class FindTheMiddleIndexInArray {
    public int findMiddleIndex(int[] nums) {
        int leftSum = 0, rightSum = Arrays.stream(nums).sum() - nums[0];
        if (leftSum == rightSum) return 0;
        for (int index = 1 ; index < nums.length ; index++) {
            rightSum -= nums[index];
            leftSum += nums[index - 1];
            if (leftSum == rightSum) return index;
        }
        return -1;
    }
}
