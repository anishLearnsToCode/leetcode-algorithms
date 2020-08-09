public class MaximumSubArray {
    public int maxSubArray(int[] array) {
        int sum = 0;
        int result = array[0];
        for (int element : array) {
            sum += element;
            result = Math.max(result, sum);
            sum = Math.max(sum, 0);
        }
        return result;
    }
}
