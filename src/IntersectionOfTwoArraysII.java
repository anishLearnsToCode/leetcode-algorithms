import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArraysII {
    public static int[] intersect(int[] array1, int[] array2) {
        Map<Integer, Integer> frequency1 = getFrequencies(array1);
        Map<Integer, Integer> frequency2 = getFrequencies(array2);
        return intersection(frequency1, frequency2);
    }

    private static Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int element : array) {
            result.put(element, result.getOrDefault(element, 0) + 1);
        }
        return result;
    }

    private static int[] intersection(Map<Integer, Integer> frequency1, Map<Integer, Integer> frequency2) {
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequency1.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            if (frequency2.containsKey(number)) {
                addNumber(result, number, Math.min(frequency, frequency2.get(number)));
            }
        }
        return toArray(result);
    }

    private static void addNumber(List<Integer> list, int number, int frequency) {
        while (frequency-- > 0) {
            list.add(number);
        }
    }

    private static int[] toArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int index = 0 ; index < array.length ; index++) {
            array[index] = list.get(index);
        }
        return array;
    }
}
