// https://leetcode.com/problems/unique-paths
// T: O(min(m, n))
// S: O(1)

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        final int M = Math.max(m, n) - 1, N = Math.min(m, n) - 1;
        long result = 1;
        for (int i = M + 1, j = 1 ; i <= M + N ; i++, j++) {
            result *= i;
            result /= j;
        }
        return (int) result;
    }
}
