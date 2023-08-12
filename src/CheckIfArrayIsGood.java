// https://leetcode.com/problems/check-if-array-is-good
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayIsGood {
    public boolean isGood(int[] array) {
        final Map<Integer, Integer> frequencies = getFrequencies(array);
        for (int i = 1 ; i < array.length - 1 ; i++) {
            if (frequencies.getOrDefault(i, 0) != 1) {
                return false;
            }
        }
        return frequencies.getOrDefault(array.length - 1, 0) == 2;
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        final Map<Integer, Integer> result = new HashMap<>();
        for (int element : array) {
            result.put(element, result.getOrDefault(element, 0) + 1);
        }
        return result;
    }
}
