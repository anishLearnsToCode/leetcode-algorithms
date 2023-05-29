// https://leetcode.com/problems/find-subarrays-with-equal-sum
// T: O(N)
// S: O(N)

import java.util.HashSet;
import java.util.Set;

public class FindSubarraysWithEqualSum {
    public boolean findSubarrays(int[] array) {
        final Set<Integer> subarraySum = new HashSet<>();
        for (int i = 0 ; i < array.length - 1 ; i++) {
            int sum = array[i] + array[i + 1];
            if (subarraySum.contains(sum)) {
                return true;
            }
            subarraySum.add(sum);
        }
        return false;
    }
}
