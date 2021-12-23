// https://leetcode.com/problems/count-special-quadruplets
// T: O(N^2)
// S: O(N^2)

import java.util.HashMap;
import java.util.Map;

public class CountSpecialQuadruplets {
    public int countQuadruplets(int[] nums) {
        final Map<Integer, Integer> differenceFreq = new HashMap<>();
        differenceFreq.put(nums[nums.length -1] - nums[nums.length - 2], 1);
        int quadruplets = 0;

        for (int b = nums.length - 3 ; b > 0 ; b--) {
            for (int a = b - 1 ; a >= 0 ; a--) {
                quadruplets += differenceFreq.getOrDefault(nums[a] + nums[b], 0);
            }

            for (int x = b + 1 ; x < nums.length ; x++) {
                int difference = nums[x] - nums[b];
                differenceFreq.put(difference, differenceFreq.getOrDefault(difference, 0) + 1);
            }
        }

        return quadruplets;
    }
}
