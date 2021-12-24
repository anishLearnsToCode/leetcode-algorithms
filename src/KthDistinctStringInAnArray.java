// https://leetcode.com/problems/kth-distinct-string-in-an-array
// T: O(|arr|)
// S: O(|arr|)

import java.util.HashMap;
import java.util.Map;

public class KthDistinctStringInAnArray {
    public String kthDistinct(String[] arr, int k) {
        final Map<String, Integer> frequencies = getFrequency(arr);
        for (String s : arr) {
            if (frequencies.get(s) == 1) {
                k--;
            }
            if (k == 0) return s;
        }
        return "";
    }

    private Map<String, Integer> getFrequency(String[] array) {
        final Map<String, Integer> frequencies = new HashMap<>();
        for (String s : array) {
            frequencies.put(s, frequencies.getOrDefault(s, 0) + 1);
        }
        return frequencies;
    }
}
