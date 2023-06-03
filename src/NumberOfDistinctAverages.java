// https://leetcode.com/problems/number-of-distinct-averages
// T: O(Nlog(N))
// S: O(N)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctAverages {
    public int distinctAverages(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0 ; i < nums.length / 2 ; i++) {
            int sum = nums[i] + nums[nums.length - 1 - i];
            set.add(sum);
        }

        return set.size();
    }
}
