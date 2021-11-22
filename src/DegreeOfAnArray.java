import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] numbers) {
        Map<Integer, Integer> frequencies = getFrequencies(numbers);
        Map<Integer, Integer> leftMostPosition = getLeftMostPositionOf(numbers);
        Map<Integer, Integer> rightMostPosition = getRightMostPositionOf(numbers);
        int maxFrequency = frequencies.values().stream().max(Integer::compareTo).get();
        int result = Integer.MAX_VALUE, element = 0;
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                element = entry.getKey();
                result = Math.min(result, rightMostPosition.get(element) - leftMostPosition.get(element) + 1);
            }
        }
        return result;
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int element : array) {
            result.put(element, result.getOrDefault(element, 0) + 1);
        }
        return result;
    }

    private Map<Integer, Integer> getLeftMostPositionOf(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int index = 0 ; index < array.length ; index++) {
            if (!result.containsKey(array[index])) {
                result.put(array[index], index);
            }
        }
        return result;
    }

    private Map<Integer, Integer> getRightMostPositionOf(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int index = 0 ; index < array.length ; index++) {
            result.put(array[index], index);
        }
        return result;
    }
}
