// https://leetcode.com/problems/minimum-operations-to-collect-elements
// T: O(|array|)
// S: O(k)

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumOperationsToCollectElements {
    public int minOperations(List<Integer> array, int k) {
        final Set<Integer> collection = new HashSet<>();
        for (int i = array.size() - 1 ; i >= 0 ; i--) {
            if (array.get(i) <= k) {
                collection.add(array.get(i));
            }
            if (collection.size() == k) {
                return array.size() - i;
            }
        }
        return -1;
    }
}
