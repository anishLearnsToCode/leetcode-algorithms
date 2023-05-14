// https://leetcode.com/problems/count-equal-and-divisible-pairs-in-an-array
// T: O(n^2)
// S: O(1)

public class CountEqualAndDivisiblePairsInAnArray {
    public int countPairs(int[] nums, int k) {
        int pairs = 0;
        for (int i = 0 ; i < nums.length ; i ++) {
            for (int j = i + 1 ; j < nums.length ; j++) {
                if (nums[i] == nums[j] && (i * j) % k == 0) pairs++;
            }
        }
        return pairs;
    }
}
