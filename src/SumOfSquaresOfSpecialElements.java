// https://leetcode.com/problems/sum-of-squares-of-special-elements
// T: O(N)
// S: O(1)

public class SumOfSquaresOfSpecialElements {
    public int sumOfSquares(int[] nums) {
        int result = 0;
        for (int i = 0 ; i < nums.length ; i++) {
            if (nums.length % (i + 1) == 0) {
                result += nums[i] * nums[i];
            }
        }
        return result;
    }
}
