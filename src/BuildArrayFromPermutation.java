// https://leetcode.com/problems/build-array-from-permutation
// T: O(N)
// S: O(N)

public class BuildArrayFromPermutation {
    public int[] buildArray(int[] nums) {
        final int[] result = new int[nums.length];
        for (int i = 0 ; i < nums.length ; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }
}
