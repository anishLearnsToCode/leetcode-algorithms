// https://leetcode.com/problems/find-minimum-operations-to-make-all-elements-divisible-by-three
// T: O(N)
// S: O(1)

public class FindMinimumOperationsToMakeAllElementsDivisibleByThree {
    public int minimumOperations(int[] array) {
        int minOperations = 0;
        for (int element : array) {
            if (element % 3 != 0) {
                minOperations++;
            }
        }
        return minOperations;
    }
}
