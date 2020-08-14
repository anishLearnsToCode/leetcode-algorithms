import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] array) {
        Map<Integer, Integer> frequencies = getFrequencies(array);
        int maxFrequency = frequencies.values().stream().max(Integer::compareTo).get();
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                return entry.getKey();
            }
        }

        return -1;
    }

    private static Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int element : array) {
            result.put(element, result.getOrDefault(element, 0) + 1);
        }
        return result;
    }
}
