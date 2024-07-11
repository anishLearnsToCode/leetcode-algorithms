// https://leetcode.com/problems/split-the-array
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class SplitTheArray {
    public boolean isPossibleToSplit(int[] array) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            if (frequencies.getOrDefault(element, 0) == 2) {
                return false;
            }
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return true;
    }
}
