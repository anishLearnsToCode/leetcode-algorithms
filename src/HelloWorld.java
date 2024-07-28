// T: O(N + E alp(N))
// S: O(N)

import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class HelloWorld {
    private static final List<List<Integer>> DIRECTIONS = List.of(
            List.of(1, 0),
            List.of(0, 1),
            List.of(-1, 0),
            List.of(0, -1)
    );

    public int orangesRotting(int[][] grid) {
        final Queue<int[]> queue = new LinkedList<>();
        addRottenOrangesToQueue(queue, grid);
        int maxTime = 0;

        while (!queue.isEmpty()) {
            final int[] info = queue.poll();
            final int row = info[0], column = info[1], time = info[2];

            if (grid[row][column] == 0) {
                continue;
            }

            maxTime = Math.max(time, maxTime);
            grid[row][column] = 0;

            for (int[] neighbour : getNeighbours(grid, row, column)) {
                queue.add(new int[] { neighbour[0], neighbour[1], time + 1});
            }
        }

        if (containsFreshOranges(grid)) {
            return -1;
        }
        return maxTime;
    }

    private static boolean containsFreshOranges(int[][] grid) {
        for (int[] row : grid) {
            for (int orange : row) {
                if (orange == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void addRottenOrangesToQueue(Queue<int[]> queue, int[][] grid) {
        for(int row = 0 ; row < grid.length ; row++) {
            for (int column = 0 ; column < grid[0].length ; column++) {
                if (grid[row][column] == 2) {
                    queue.add(new int[] { row, column, 0 });
                }
            }
        }
    }

    private static List<int[]> getNeighbours(int[][] grid, int row, int column) {
        final List<int[]> result = new ArrayList<>();
        for (List<Integer> direction : DIRECTIONS) {
            final int r = row + direction.get(0), c = column + direction.get(1);
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1) {
                result.add(new int[] {r, c});
            }
        }
        return result;
    }
}