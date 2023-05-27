// https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts
// T: O(|nums|)
// S: O(|nums|)

import java.util.HashSet;
import java.util.Set;

public class MakeArrayZeroBySubtractingEqualAmounts {
    public int minimumOperations(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (int element : nums) {
            if (element != 0) {
                set.add(element);
            }
        }
        return set.size();
    }
}
