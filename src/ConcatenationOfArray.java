// https://leetcode.com/problems/concatenation-of-array
// T: O(N)
// S: O(N)

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        final int[] result = new int[nums.length * 2];
        for (int i = 0 ; i < nums.length ; i++) result[i] = nums[i];
        for (int i = nums.length ; i < result.length ; i++) result[i] = nums[i - nums.length];
        return result;
    }
}
