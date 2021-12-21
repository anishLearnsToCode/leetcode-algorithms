import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SumOfUniqueElements {
    public int sumOfUnique(int[] nums) {
        final Set<Integer> uniqueElements = uniqueElements(nums);
        return sum(uniqueElements);
    }

    private Set<Integer> uniqueElements(int[] array) {
        final Map<Integer, Integer> frequencies = getFrequencies(array);
        final Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() == 1) set.add(entry.getKey());
        }
        return set;
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }

    private int sum(Collection<Integer> collection) {
        int sum = 0;
        for (int element : collection) {
            sum += element;
        }
        return sum;
    }
}
