// https://leetcode.com/problems/product-of-array-except-self
// T: O(N)
// S: O(1)

public class ProductOfArrayExceptItself {

    private record ProductDetails(int nonZeroProduct, int numberOfZeros) { }

    public int[] productExceptSelf(int[] nums) {
        final ProductDetails productDetails = getProductDetails(nums);
        if (productDetails.numberOfZeros > 1) return new int[nums.length];
        if (productDetails.numberOfZeros == 1) return productSumOnlyWhenZero(nums, productDetails.nonZeroProduct);
        final int[] result = new int[nums.length];
        for (int i = 0 ; i < result.length ; i++) {
            result[i] = productDetails.nonZeroProduct / nums[i];
        }
        return result;
    }

    private int[] productSumOnlyWhenZero(int[] array, int product) {
        final int[] result = new int[array.length];
        for (int i = 0 ; i < array.length ; i++) {
            if (array[i] == 0) result[i] = product;
        }
        return result;
    }

    private ProductDetails getProductDetails(int[] array) {
        int numberOfZeros = 0;
        int nonZeroProduct = 1;
        for (int element : array) {
            if (element == 0) numberOfZeros++;
            else nonZeroProduct *= element;
        }
        return new ProductDetails(nonZeroProduct, numberOfZeros);
    }
}
