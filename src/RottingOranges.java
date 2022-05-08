import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    private record RottenOrange(int row, int column, int time) {}

    private static final int FRESH_ORANGE = 1;
    private static final int ROTTEN_ORANGE = 2;

    public int orangesRotting(int[][] grid) {
        final Queue<RottenOrange> queue = new LinkedList<>();
        addAllRottenOrangesToQueue(grid, queue);
        int elapsedTime = 0;

        while (!queue.isEmpty()) {
            RottenOrange orange = queue.poll();
            addAdjacentOrangesInQueue(orange, queue, grid);
            elapsedTime = Math.max(elapsedTime, orange.time);
        }

        if (containsFreshOranges(grid)) return -1;
        return elapsedTime;
    }

    private void addAllRottenOrangesToQueue(int[][] grid, final Queue<RottenOrange> queue) {
        for (int row = 0 ; row < grid.length ; row++) {
            for (int column = 0 ; column < grid[0].length ; column++) {
                if (isRottenOrange(grid[row][column])) {
                    queue.add(new RottenOrange(row, column, 0));
                }
            }
        }
    }

    private boolean isRottenOrange(int orange) {
        return orange == ROTTEN_ORANGE;
    }

    private boolean isFreshOrange(int orange) {
        return orange == FRESH_ORANGE;
    }

    private boolean containsFreshOranges(int[][] grid) {
        for (int[] row : grid) {
            for (int orange : row) {
                if (isFreshOrange(orange)) return true;
            }
        }
        return false;
    }

    private void addAdjacentOrangesInQueue(RottenOrange orange, Queue<RottenOrange> queue, int[][] grid) {
        addOrangeOnTop(orange, queue, grid);
        addOrangeOnRight(orange, queue, grid);
        addOrangeOnBottom(orange, queue, grid);
        addOrangeOnLeft(orange, queue, grid);
    }

    private void addOrangeOnTop(RottenOrange orange, Queue<RottenOrange> queue, int[][] grid) {
        if (isValidPosition(grid, orange.row - 1, orange.column) && isFreshOrange(grid[orange.row - 1][orange.column])) {
            markRotten(grid, orange.row - 1, orange.column);
            queue.add(new RottenOrange(orange.row - 1, orange.column, orange.time + 1));
        }
    }

    private void addOrangeOnRight(RottenOrange orange, Queue<RottenOrange> queue, int[][] grid) {
        if (isValidPosition(grid, orange.row, orange.column + 1) && isFreshOrange(grid[orange.row][orange.column + 1])) {
            markRotten(grid, orange.row, orange.column + 1);
            queue.add(new RottenOrange(orange.row, orange.column + 1, orange.time + 1));
        }
    }

    private void addOrangeOnBottom(RottenOrange orange, Queue<RottenOrange> queue, int[][] grid) {
        if (isValidPosition(grid, orange.row + 1, orange.column) && isFreshOrange(grid[orange.row + 1][orange.column])) {
            markRotten(grid, orange.row + 1, orange.column);
            queue.add(new RottenOrange(orange.row + 1, orange.column, orange.time + 1));
        }
    }

    private void addOrangeOnLeft(RottenOrange orange, Queue<RottenOrange> queue, int[][] grid) {
        if (isValidPosition(grid, orange.row, orange.column - 1) && isFreshOrange(grid[orange.row][orange.column - 1])) {
            markRotten(grid, orange.row, orange.column - 1);
            queue.add(new RottenOrange(orange.row, orange.column - 1, orange.time + 1));
        }
    }

    private boolean isValidPosition(int[][] grid, int row, int column) {
        return row >= 0
                && row < grid.length
                && column >= 0
                && column < grid[0].length;
    }

    private void markRotten(int[][] grid, int row, int column) {
        grid[row][column] = ROTTEN_ORANGE;
    }
}
