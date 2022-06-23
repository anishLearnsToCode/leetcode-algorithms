// https://leetcode.com/problems/contains-duplicate-iii
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {

    private long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) return false;

        final Map<Long, Long> buckets = new HashMap<>();
        final long w = (long) t + 1;

        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (buckets.containsKey(m))
                return true;
            if (buckets.containsKey(m - 1) && Math.abs(nums[i] - buckets.get(m - 1)) < w)
                return true;
            if (buckets.containsKey(m + 1) && Math.abs(nums[i] - buckets.get(m + 1)) < w)
                return true;
            buckets.put(m, (long)nums[i]);
            if (i >= k) buckets.remove(getID(nums[i - k], w));
        }

        return false;
    }
}
