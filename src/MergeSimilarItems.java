// https://leetcode.com/problems/merge-similar-items
// T: O(Nlog(N))
// S: O(N)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        final Map<Integer, Integer> valueToWeight = getValueToWeightMapping(items1);
        for (int[] row : items2) {
            if (valueToWeight.containsKey(row[0])) {
                valueToWeight.put(row[0], valueToWeight.get(row[0]) + row[1]);
            } else {
                valueToWeight.put(row[0], row[1]);
            }
        }

        final List<List<Integer>> list = toList(valueToWeight);
        list.sort(Comparator.comparingInt(a -> a.get(0)));
        return list;
    }

    private List<List<Integer>> toList(Map<Integer, Integer> mapping) {
        final List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
            result.add(List.of(entry.getKey(), entry.getValue()));
        }
        return result;
    }

    private Map<Integer, Integer> getValueToWeightMapping(int[][] array) {
        final Map<Integer, Integer> result = new HashMap<>();
        for (int[] row : array) {
            result.put(row[0], row[1]);
        }
        return result;
    }
}
