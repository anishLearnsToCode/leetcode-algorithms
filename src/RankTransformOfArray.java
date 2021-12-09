import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTransformOfArray {
    public int[] arrayRankTransform(int[] array) {
        final Map<Integer, Integer> elementRank = getElementRanks(array);
        final int[] result = new int[array.length];
        for (int index = 0 ; index < array.length ; index++) {
            result[index] = elementRank.get(array[index]);
        }
        return result;
    }

    private Map<Integer, Integer> getElementRanks(int[] array) {
        final int[] sorted = array.clone();
        Arrays.sort(sorted);
        final Map<Integer, Integer> result = new HashMap<>();
        for (int i = 0, rank = 1 ; i < sorted.length ; i++) {
            if (!result.containsKey(sorted[i])) {
                result.put(sorted[i], rank++);
            }
        }
        return result;
    }
}
