import java.util.HashMap;
import java.util.Map;

public class MakeTwoArraysEqualByReversingSubArrays {
    public boolean canBeEqual(int[] target, int[] array) {
        Map<Integer, Integer> targetFrequencies = getFrequencies(target);
        Map<Integer, Integer> arrayFrequencies = getFrequencies(array);
        return targetFrequencies.equals(arrayFrequencies);
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }
}
