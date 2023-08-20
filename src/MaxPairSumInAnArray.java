// https://leetcode.com/problems/max-pair-sum-in-an-array
// T: O(N)
// S: O(1)

public class MaxPairSumInAnArray {
    public int maxSum(int[] nums) {
        final int[] digitMaxSum = new int[9];
        int maxPairSum = 0;
        for (int element : nums) {
            final int maxDigit = getMaxDigit(element);
            if (digitMaxSum[maxDigit - 1] != 0) {
                maxPairSum = Math.max(maxPairSum, digitMaxSum[maxDigit - 1] + element);
            }
            digitMaxSum[maxDigit - 1] = Math.max(digitMaxSum[maxDigit - 1], element);
        }
        return maxPairSum == 0 ? -1 : maxPairSum;
    }

    private int getMaxDigit(int number) {
        final String string = number + "";
        int maxDigit = 0;
        for (int i = 0 ; i < string.length() ; i++) {
            maxDigit = Math.max(maxDigit, string.charAt(i) - '0');
        }
        return maxDigit;
    }
}
