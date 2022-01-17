import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        final Map<Integer, Integer> frequencies = getElementFrequencies(nums);
        final List<List<Integer>> result = new ArrayList<>();
        computeSubSets(frequencies, result, new LinkedList<>(), 0, nums.length);
        return result;
    }

    private void computeSubSets(Map<Integer, Integer> frequencies, List<List<Integer>> result, LinkedList<Integer> current, int depth, int maxDepth) {
        if (depth == maxDepth) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getValue() > 0) {
                entry.setValue(entry.getValue() - 1);
                computeSubSets(frequencies, result, current, depth + 1, maxDepth);
                current.add(entry.getKey());
                computeSubSets(frequencies, result, current, depth + 1, maxDepth);
                current.removeLast();
                entry.setValue(entry.getValue() + 1);
            }
        }
    }

    private Map<Integer, Integer> getElementFrequencies(int[] array) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }
}
