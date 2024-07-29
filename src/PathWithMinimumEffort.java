// https://leetcode.com/problems/path-with-minimum-effort
// T: O(m * n * log(m * n))
// S: O(m * n)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
    private record Position(int x, int y) {}

    private record Info(Position position, int effort) {}

    private static final int[][] Directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    // T: O(m * n * log(m * n)) S: O(m * n)
    public int minimumEffortPath(int[][] heights) {
        final int[][] minEffort = initialiseMinEfforts(heights.length, heights[0].length);
        final Queue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.effort));
        queue.add(new Info(new Position(0, 0), 0));

        while (!queue.isEmpty()) {
            final Info info = queue.poll();
            if (info.effort >= minEffort[info.position.x][info.position.y]) {
                continue;
            }
            minEffort[info.position.x][info.position.y] = info.effort;

            for (Position position : validPositions(heights, info.position)) {
                queue.add(new Info(position, Math.max(info.effort, absDiff(info.position, position, heights))));
            }
        }

        return minEffort[heights.length - 1][heights[0].length - 1];
    }

    // T: O(m * n), S: O(m * n)
    private static int[][] initialiseMinEfforts(int rows, int columns) {
        final int[][] result = new int[rows][columns];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return result;
    }

    // T: O(1), S: O(1)
    private static int absDiff(Position p1, Position p2, int[][] heights) {
        return Math.abs(heights[p1.x][p1.y] - heights[p2.x][p2.y]);
    }

    // T: O(1), S: O(1)
    private static List<Position> validPositions(int[][] heights, Position position) {
        final List<Position> result = new ArrayList<>();
        for (int[] direction : Directions) {
            final int row = position.x + direction[0], column = position.y + direction[1];
            if (row >= 0 && row < heights.length && column >= 0 && column < heights[0].length) {
                result.add(new Position(row, column));
            }
        }
        return result;
    }
}
