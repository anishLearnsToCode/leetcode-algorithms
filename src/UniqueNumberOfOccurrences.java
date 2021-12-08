import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] array) {
        Map<Integer, Integer> frequencies = getFrequencies(array);
        return areUnique(frequencies.values());
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }

    private boolean areUnique(Collection<Integer> numbers) {
        Set<Integer> values = new HashSet<>();
        for (int number : numbers) {
            if (values.contains(number)) return false;
            values.add(number);
        }
        return true;
    }
}
