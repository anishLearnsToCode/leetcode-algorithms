import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {
    public int findLHS(int[] array) {
        Map<Integer, Integer> frequencies = getFrequencies(array);
        int value, frequency, result = 0;
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            value = entry.getKey();
            frequency = entry.getValue();
            result = Math.max(result, Math.max(
                    frequencies.containsKey(value - 1) ? frequency + frequencies.get(value - 1) : 0,
                    frequencies.containsKey(value + 1) ? frequency + frequencies.get(value + 1) : 0
            ));
        }
        return result;
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }
}
