// https://leetcode.com/problems/find-the-array-concatenation-value
// T: O(N)
// S: O(1)

public class FindTheArrayConcatenationValue {
    public long findTheArrayConcVal(int[] nums) {
        long result = 0;

        for (int i = 0 ; i < nums.length / 2 ; i++) {
            result += Integer.parseInt(nums[i] + "" + nums[nums.length - 1 - i]);
        }

        if (nums.length % 2 == 1) {
            result += nums[nums.length / 2];
        }

        return result;
    }
}
