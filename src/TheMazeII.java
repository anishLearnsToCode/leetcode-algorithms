// https://leetcode.com/problems/the-maze-ii
// T: O(m * n * log(m * n))
// S: O(m * n)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheMazeII {
    private static final int[][] DIRECTIONS = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        final int rows = maze.length, columns = maze[0].length;
        final int[][] distance = dijkstra(maze, start);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    // T: O(m * n * log(mn))
    // S: O(m * n)
    public int[][] dijkstra(int[][] maze, int[] start) {
        final int[][] distance = getDistances(maze.length, maze[0].length);
        final Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        queue.add(new int[] { start[0], start[1], 0 });

        while (!queue.isEmpty()) {
            final int[] s = queue.poll();
            final int row = s[0], column = s[1], d = s[2];

            if (distance[row][column] <= d) {
                continue;
            }

            distance[row][column] = d;

            for (int[] position: validPositions(maze, s[0], s[1])) {
                final int newDistance = distance[row][column] + manhattanDistance(s[0], s[1], position);
                queue.add(new int[] { position[0], position[1], newDistance});
            }
        }

        return distance;
    }

    // T: O(m + n)
    // S: O(1)
    private static List<int[]> validPositions(int[][] grid, int row, int column) {
        final List<int[]> result = new ArrayList<>();
        for (int[] direction : DIRECTIONS) {
            int i = row, j = column;
            while (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 0) {
                i += direction[0];
                j += direction[1];
            }
            result.add(new int[] { i - direction[0], j - direction[1] });
        }
        return result;
    }

    // T: O(m * n)
    // S: O(m * n)
    private static int[][] getDistances(int rows, int columns) {
        final int[][] result = new int[rows][columns];
        for (int i = 0 ; i < rows ; i++) {
            for (int j = 0 ; j < columns ; j++) {
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        return result;
    }

    // T: O(1), S: O(1)
    private static int manhattanDistance(int row, int column, int[] position) {
        return Math.abs(row - position[0]) + Math.abs(column - position[1]);
    }
}
