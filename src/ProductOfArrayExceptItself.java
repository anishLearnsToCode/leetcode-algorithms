// https://leetcode.com/problems/product-of-array-except-self
// T: O(N)
// S: O(1)

public class ProductOfArrayExceptItself {

    public int[] productExceptSelf(int[] nums) {
        final int[] result = new int[nums.length];
        multipleWithLeftPrefix(nums, result);
        multiplyWithRightPostfix(nums, result);
        return result;
    }

    private void multipleWithLeftPrefix(int[] numbers, int[] result) {
        result[0] = 1;
        for(int i = 1 ; i < numbers.length ; i++) {
            result[i] = result[i - 1] * numbers[i - 1];
        }
    }

    private void multiplyWithRightPostfix(int[] numbers, int[] result) {
        int right = 1;
        for(int i = result.length - 1 ; i >= 0 ; i--) {
            result[i] *= right;
            right *= numbers[i];
        }
    }
}
