// https://leetcode.com/problems/delete-greatest-value-in-each-row
// T: O(mn * log(N))
// S: O(log(n))

import java.util.Arrays;

public class DeleteGreatestValueInEachRow {
    public int deleteGreatestValue(int[][] grid) {
        final int columns = grid[0].length;
        int maxDeletions = 0;

        sortAllRows(grid);

        for (int column = 0 ; column < columns ; column++) {
            maxDeletions += columnMax(grid, column);
        }

        return maxDeletions;
    }

    private int columnMax(int[][] grid, int column) {
        int max = Integer.MIN_VALUE;
        for (int[] row : grid) {
            max = Math.max(max, row[column]);
        }
        return max;
    }

    private void sortAllRows(int[][] grid) {
        for (int[] row : grid) {
            Arrays.sort(row);
        }
    }
}
