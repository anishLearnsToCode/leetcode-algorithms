// https://leetcode.com/problems/k-items-with-the-maximum-sum
// T: O(1)
// S: O(1)

public class KItemsWithTheMaximumSum {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int maxSum = Math.min(numOnes, k);
        k -= numOnes;
        if (k <= 0) return maxSum;

        k -= numZeros;
        if (k <= 0) return maxSum;

        return maxSum - k;
    }
}
