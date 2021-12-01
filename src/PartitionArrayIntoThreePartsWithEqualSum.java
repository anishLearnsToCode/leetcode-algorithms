import java.util.Arrays;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] array) {
        final int totalSum = Arrays.stream(array).sum();
        if (totalSum % 3 != 0) return false;
        int count = 0;
        for (int index = 0, sum = 0; index < array.length - 1 ; index++) {
            sum += array[index];
            if (sum == totalSum / 3) {
                count++;
                sum = 0;
            }
        }
        return count >= 2;
    }
}
