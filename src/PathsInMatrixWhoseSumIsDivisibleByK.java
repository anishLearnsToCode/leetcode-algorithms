// https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k
// T: O()
// S: O()

import java.util.LinkedList;
import java.util.Queue;

public class PathsInMatrixWhoseSumIsDivisibleByK {
    private static final int MODULO = (int) (10e9 + 7);

    public int numberOfPaths(int[][] grid, int k) {
        final int rows = grid.length, columns = grid[0].length;
        // row, column, currentSum
        final Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0, grid[0][0]});

        int paths = 0;

        while (!queue.isEmpty()) {
            final int[] position = queue.poll();
            final int row = position[0], column = position[1], currentSum = position[2];
            if (row == rows - 1 && column == columns - 1) {
                if (currentSum % k == 0) {
                    paths = (paths + 1) % MODULO;
                }
                continue;
            }

            if (column + 1 < columns) {
                queue.add(new int[] { row, column + 1, currentSum + grid[row][column + 1]});
            }
            if (row + 1 < rows) {
                queue.add(new int[] { row + 1, column, currentSum + grid[row + 1][column]});
            }
        }

        return paths;
    }
}
