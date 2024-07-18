// https://leetcode.com/problems/check-if-grid-satisfies-conditions
// T: O(m * n)
// S: O(1)

public class CheckIfGridSatisfiesConditions {
    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[i].length ; j++) {
                if (j + 1 < grid[i].length && grid[i][j] == grid[i][j + 1]) {
                    return false;
                }
                if (i + 1 < grid.length && grid[i][j] != grid[i + 1][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
