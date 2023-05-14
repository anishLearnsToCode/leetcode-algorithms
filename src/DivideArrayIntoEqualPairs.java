// https://leetcode.com/problems/divide-array-into-equal-pairs
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class DivideArrayIntoEqualPairs {
    public static boolean divideArray(int[] array) {
        final Map<Integer, Integer> frequencies = getFrequencies(array);
        return allFrequenciesAreEven(frequencies);
    }

    private static boolean allFrequenciesAreEven(Map<Integer, Integer> frequencies) {
        for (int frequency : frequencies.values()) {
            if (frequency % 2 == 1) return false;
        }
        return true;
    }

    private static Map<Integer, Integer> getFrequencies(int[] array) {
        final Map<Integer, Integer> result = new HashMap<>();
        for (int element : array) {
            result.put(element, result.getOrDefault(element, 0) + 1);
        }
        return result;
    }
}
