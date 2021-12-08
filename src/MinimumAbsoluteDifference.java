import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] array) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);
        long minAbsDifference = Long.MAX_VALUE;
        for (int i = 0 ; i < array.length - 1 ; i++) {
            if (array[i + 1] - array[i] < minAbsDifference) {
                minAbsDifference = array[i + 1] - array[i];
                result = new ArrayList<>();
                result.add(List.of(array[i], array[i + 1]));
            } else if (array[i + 1] - array[i] == minAbsDifference) {
                result.add(List.of(array[i], array[i + 1]));
            }
        }
        return result;
    }
}
