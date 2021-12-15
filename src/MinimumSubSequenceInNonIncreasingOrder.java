import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubSequenceInNonIncreasingOrder {
    public List<Integer> minSubsequence(int[] array) {
        Arrays.sort(array);
        final int sum = Arrays.stream(array).sum();
        final List<Integer> result = new ArrayList<>();
        result.add(array[array.length - 1]);
        for (int index = array.length - 2, current = array[array.length - 1] ; index >= 0 ; index--) {
            if (current > sum - current) break;
            current += array[index];
            result.add(array[index]);
        }
        return result;
    }
}
