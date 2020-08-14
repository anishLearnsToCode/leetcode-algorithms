import java.util.HashMap;
import java.util.Map;

public class TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] array, int target) {
        for (int i = 0, j = array.length - 1 ; i != j ; ) {
            if (array[i] + array[j] == target) {
                return new int[] {i + 1, j + 1};
            } else if (array[i] + array[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[0];
    }
}
