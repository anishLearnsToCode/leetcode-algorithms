import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortArrayByIncreasingFrequency {
    public int[] frequencySort(int[] array) {
        Map<Integer, Integer> frequencies = getFrequencies(array);

        return toArray(Arrays.stream(array).boxed().sorted((a, b) -> {
            if (frequencies.get(a).equals(frequencies.get(b))) return b - a;
            return frequencies.get(a) - frequencies.get(b);
        }).collect(Collectors.toList()));
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }

    private int[] toArray(List<Integer> list) {
        final int[] array = new int[list.size()];
        for (int index = 0 ; index < list.size() ; index++) {
            array[index] = list.get(index);
        }
        return array;
    }
}
