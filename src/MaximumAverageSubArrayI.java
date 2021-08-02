public class MaximumAverageSubArrayI {
    public double findMaxAverage(int[] numbers, int k) {
        long sum = 0;
        for (int i = 0 ; i < k ; i++) {
            sum += numbers[i];
        }
        double maxSum = sum;
        for (int index = 0 ; index < numbers.length - k ; index++) {
            sum += numbers[index + k] - numbers[index];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum / k;
    }
}
