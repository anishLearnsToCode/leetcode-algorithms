// https://leetcode.com/problems/the-maze-iii
// T: O(m * n log(m * n))
// S: O(m * n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TheMazeIII {
    private record Info(int[] position, int distance, String path) {}

    private record Position(int[] position, String direction) {}

    private static final Position[] DIRECTIONS = new Position[] {
            new Position(new int[] { 1, 0 }, "d"),
            new Position(new int[] { 0, -1 }, "l"),
            new Position(new int[] { 0, 1 }, "r"),
            new Position(new int[] { -1, 0 }, "u")
    };

    // T: O(m * n * log(m * n)), S: O(m * n)
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        final int[][] distances = getDistances(maze.length, maze[0].length);
        final Queue<Info> queue = new PriorityQueue<>((a, b) -> {
            if (a.distance == b.distance) {
                return a.path.compareTo(b.path);
            }
            return Integer.compare(a.distance, b.distance);
        });
        queue.add(new Info(ball, 0, ""));
        String path = null;

        while (!queue.isEmpty()) {
            final Info info = queue.poll();

            if (distances[info.position[0]][info.position[1]] <= info.distance) {
                continue;
            }

            distances[info.position[0]][info.position[1]] = info.distance;

            if (info.position[0] == hole[0] && info.position[1] == hole[1]) {
                if (path == null) {
                    path = info.path;
                } else {
                    path = path.compareTo(info.path) > 0 ? info.path : path;
                }
            }

            for (Position position : validPositions(maze, info.position, hole)) {
                queue.add(new Info(
                        position.position,
                        info.distance + manhattanDistance(position.position, info.position),
                        info.path + position.direction
                ));
            }
        }

        final int minDistance = distances[hole[0]][hole[1]];
        return minDistance == Integer.MAX_VALUE ? "impossible" : path;
    }

    // T: O(1), S:O(1)
    private static int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

    // T: O(m + n), S: O(1)
    private static List<Position> validPositions(int[][] grid, int[] position, int[] target) {
        final List<Position> result = new ArrayList<>();
        for (Position p : DIRECTIONS) {
            int row = position[0], column = position[1];
            while (row >= 0 && row < grid.length
                    && column >= 0 && column < grid[0].length && grid[row][column] == 0 &&
                    (row != target[0] || column != target[1])) {
                row += p.position[0];
                column += p.position[1];
            }
            if (row == target[0] && column == target[1]) {
                result.add(new Position(new int[] { row, column}, p.direction));
            } else {
                result.add(new Position(new int[]{row - p.position[0], column - p.position[1]}, p.direction));
            }
        }
        return result;
    }

    // T: O(m * n), S: O(m * n)
    private static int[][] getDistances(int rows, int columns) {
        final int[][] distances = new int[rows][columns];
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return distances;
    }
}
