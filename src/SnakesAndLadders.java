// https://leetcode.com/problems/snakes-and-ladders
// T: O(n^2)
// S: O(n^2)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class SnakesAndLadders {
    private record Position(int row, int column) {}

    private record Info(int square, int cost) {}

    // BFS: T: O(V + E), V = n^2, E = 6n^2 T: O(n^2), S: O(V) = O(n^2)
    public int snakesAndLadders(int[][] board) {
        final int n = board.length;
        final Map<Integer, Position> squareToPosition = createSquaresToPositions(n);
        final Queue<Info> queue = new LinkedList<>() {{ add(new Info(1, 0)); }};
        final int[] distances = initializeDistances(n);

        while (!queue.isEmpty()) {
            final Info info = queue.poll();
            if (distances[info.square] <= info.cost) {
                continue;
            }

            distances[info.square] = info.cost;

            for (int nextSquare : validPositions(board, info.square, squareToPosition)) {
                queue.add(new Info(nextSquare, info.cost + 1));
            }
        }

        return distances[n * n] == Integer.MAX_VALUE ? -1 : distances[n * n];
    }

    // T: O(1), S: O(1)
    private static List<Integer> validPositions(int[][] grid, int square, Map<Integer, Position> positions) {
        final int n = grid.length;
        final List<Integer> result = new ArrayList<>();
        for (int i = 1 ; i <= 6 ; i++) {
            final int nextSquare = square + i;
            if (nextSquare > n * n) {
                break;
            }
            final Position position = positions.get(nextSquare);
            if (grid[position.row][position.column] == -1) {
                result.add(nextSquare);
            } else {
                result.add(grid[position.row][position.column]);
            }
        }
        return result;
    }

    // T: O(n^2), S: O(n^2)
    private static int[] initializeDistances(int n) {
        final int[] distances = new int[n * n + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);
        return distances;
    }

    // T: O(n^2), S: O(n^2)
    private static Map<Integer, Position> createSquaresToPositions(int n) {
        final Map<Integer, Position> result = new HashMap<>();
        for (int i = 1 ; i <= n * n ; i++) {
            final int row = n - ((i - 1) / n) - 1;
            final int column = (n - 1 - row) % 2 == 0 ? (i - 1) % n : n - 1 - ((i - 1) % n);
            result.put(i, new Position(row, column));
        }
        return result;
    }
}
