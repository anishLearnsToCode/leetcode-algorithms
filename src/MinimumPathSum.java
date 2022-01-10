// https://leetcode.com/problems/minimum-path-sum
// T: O(m * n)
// S: O(1)

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        final int rows = grid.length, columns = grid[0].length;

        // last row
        for (int column = columns - 2 ; column >= 0 ; column--) {
            grid[rows - 1][column] += grid[rows - 1][column + 1];
        }

        // last column
        for (int row = rows - 2 ; row >= 0 ; row--) {
            grid[row][columns - 1] += grid[row + 1][columns - 1];
        }

        for (int row = rows - 2 ; row >= 0 ; row--) {
            for (int column = columns - 2 ; column >= 0 ; column--) {
                grid[row][column] += Math.min(grid[row + 1][column], grid[row][column + 1]);
            }
        }

        return grid[0][0];
    }
}
