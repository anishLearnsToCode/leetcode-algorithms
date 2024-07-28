// https://leetcode.com/problems/shortest-path-in-binary-matrix
// N = total number of vertices
// T: O(N)
// S: O(N)

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {
    private static final List<List<Integer>> directions = List.of(
            List.of(-1, -1),
            List.of(-1, 0),
            List.of(-1, 1),
            List.of(1, -1),
            List.of(1, 0),
            List.of(1, 1),
            List.of(0, -1),
            List.of(0, 1)
    );

    public int shortestPathBinaryMatrix(int[][] grid) {
        final int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        final Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        grid[0][0] = 1;

        while (!queue.isEmpty()) {
            final int[] position = queue.poll();
            if (position[0] == n - 1 && position[1] == n - 1) {
                return grid[n - 1][n - 1];
            }

            for (int[] neighbour : getNeighbours(position, grid)) {
                queue.add(neighbour);
                grid[neighbour[0]][neighbour[1]] = grid[position[0]][position[1]] + 1;
            }
        }

        return -1;
    }

    private static List<int[]> getNeighbours(int[] position, int[][] grid) {
        final List<int[]> result = new ArrayList<>();
        for (List<Integer> direction : directions) {
            final int row = position[0] + direction.get(0);
            final int column = position[1] + direction.get(1);
            if (isValid(grid, row, column) && grid[row][column] == 0) {
                result.add(new int[] { row, column });
            }
        }
        return result;
    }

    private static boolean isValid(int[][] grid, int row, int column) {
        final int n = grid.length;
        return row >= 0 && row < n && column >= 0 && column < n;
    }
}
