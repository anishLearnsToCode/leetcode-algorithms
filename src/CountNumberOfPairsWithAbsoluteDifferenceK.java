// https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithAbsoluteDifferenceK {
    public int countKDifference(int[] nums, int k) {
        final Map<Integer, Integer> frequency = new HashMap<>();
        int pairs = 0;
        for (int element : nums) {
            pairs += frequency.getOrDefault(element - k, 0);
            pairs += frequency.getOrDefault(element + k, 0);
            frequency.put(element, frequency.getOrDefault(element, 0) + 1);
        }
        return pairs;
    }
}
