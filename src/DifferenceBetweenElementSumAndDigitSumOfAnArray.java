// https://leetcode.com/problems/difference-between-element-sum-and-digit-sum-of-an-array
// T: O(N)
// S: O(1)

import java.util.Arrays;

public class DifferenceBetweenElementSumAndDigitSumOfAnArray {
    public int differenceOfSum(int[] nums) {
        final int elementSum = Arrays.stream(nums).sum();
        final int digitSum = getDigitSum(nums);
        return Math.abs(elementSum - digitSum);
    }

    private int getDigitSum(int[] array) {
        int sum = 0;
        for (int number : array) {
            sum += getDigitSum(number);
        }
        return sum;
    }

    private int getDigitSum(int number) {
        final String num = number + "";
        int sum = 0;
        for (int index = 0 ; index < num.length() ; index++) {
            int digit = num.charAt(index) - '0';
            sum += digit;
        }
        return sum;
    }
}
