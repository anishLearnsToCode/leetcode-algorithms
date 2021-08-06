public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        int result = 1, current = 1;
        for (int index = 1 ; index < nums.length ; index++) {
            if (nums[index] > nums[index - 1]) {
                current++;
                result = Math.max(result, current);
            } else {
                current = 1;
            }
        }
        return result;
    }
}
