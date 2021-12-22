// https://leetcode.com/problems/sum-of-all-subset-xor-totals
// T: O(N)
// S: O(1)

public class SumOfAllSubsetXORTotals {
    public int subsetXORSum(int[] nums) {
        int or = 0;
        for (int element : nums) {
            or |= element;
        }
        return or * (1 << nums.length - 1);
    }
}
