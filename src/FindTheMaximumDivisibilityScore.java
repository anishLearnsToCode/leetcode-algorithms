// https://leetcode.com/problems/find-the-maximum-divisibility-score
// m: length of divisors
// n: length of nums
// T: O(m * n)
// S: O(m)

import java.util.HashSet;
import java.util.Set;

public class FindTheMaximumDivisibilityScore {
    public int maxDivScore(int[] nums, int[] divisors) {
        final Set<Integer> setDivisors = new HashSet<>();
        int maxDivisibilityScore = 0, minDivisor = Integer.MAX_VALUE;
        for (int divisor : divisors) {
            if (setDivisors.contains(divisor)) {
                continue;
            }
            setDivisors.add(divisor);
            final int divisorScore = getDivisorScore(nums, divisor);
            if (divisorScore > maxDivisibilityScore) {
                maxDivisibilityScore = divisorScore;
                minDivisor = divisor;
            } else if (divisorScore == maxDivisibilityScore) {
                minDivisor = Math.min(minDivisor, divisor);
            }
        }
        return minDivisor;
    }

    private int getDivisorScore(int[] array, int divisor) {
        int count = 0;
        for (int element : array) {
            if (element % divisor == 0) count++;
        }
        return count;
    }
}
