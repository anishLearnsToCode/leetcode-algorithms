import java.util.Arrays;

public class FindPivotIndex {
    public int pivotIndex(int[] array) {
        int sum = Arrays.stream(array).sum();
        for (int index = 0, leftSum = 0 ; index < array.length ; index++) {
            leftSum += index - 1 >= 0 ? array[index - 1] : 0;
            sum -= array[index];
            if (leftSum == sum) {
                return index;
            }
        }
        return -1;
    }
}
