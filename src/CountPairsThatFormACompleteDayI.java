// https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class CountPairsThatFormACompleteDayI {
    public int countCompleteDayPairs(int[] hours) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        int pairs = 0;

        for (int element : hours) {
            int required = (24 - (element % 24)) % 24;
            int current = element % 24;
            pairs += frequencies.getOrDefault(required, 0);
            frequencies.put(current, frequencies.getOrDefault(current, 0) + 1);
        }

        return pairs;
    }
}
