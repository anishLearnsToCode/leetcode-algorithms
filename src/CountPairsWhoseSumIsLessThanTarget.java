// https://leetcode.com/problems/count-pairs-whose-sum-is-less-than-target/description
// T: O(NlogN)
// S: O(logN)

import java.util.List;

public class CountPairsWhoseSumIsLessThanTarget {
    public int countPairs(List<Integer> nums, int target) {
        int pairs = 0;
        nums.sort(Integer::compareTo);
        for (int i = 0, j = nums.size() - 1 ; i < j ; ) {
            if (nums.get(i) + nums.get(j) < target) {
                pairs += j - i;
                i++;
            } else {
                j--;
            }
        }
        return pairs;
    }
}
