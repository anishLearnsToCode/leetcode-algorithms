import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class RottingOranges {
    private static final int EMPTY_CELL = 0;
    private static final int FRESH_ORANGE = 1;
    private static final int ROTTEN_ORANGE = 2;

    private static final class Orange {
        private final int row;
        private final int column;
        private final int minutes;

        private Orange(int row, int column, int minutes) {
            this.row = row;
            this.column = column;
            this.minutes = minutes;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Orange) obj;
            return this.row == that.row && this.column == that.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }

    public static int orangesRotting(int[][] grid) {
        final Queue<Orange> oranges = allRottingOranges(grid);
        final Set<Orange> visited = new HashSet<>();
        int result = 0;
        while (!oranges.isEmpty()) {
            Orange orange = oranges.poll();
            if (!isValidPosition(orange, grid) || visited.contains(orange) || isEmptyCell(grid, orange)) {
                continue;
            }
            visited.add(orange);
            grid[orange.row][orange.column] = ROTTEN_ORANGE;
            oranges.add(new Orange(orange.row - 1, orange.column, orange.minutes + 1));
            oranges.add(new Orange(orange.row, orange.column + 1, orange.minutes + 1));
            oranges.add(new Orange(orange.row + 1, orange.column, orange.minutes + 1));
            oranges.add(new Orange(orange.row, orange.column - 1, orange.minutes + 1));
            result = Math.max(result, orange.minutes);
        }
        if (allAreRotten(grid)) return result;
        return -1;
    }

    private static boolean allAreRotten(int[][] grid) {
        for (int[] row : grid) {
            for (int orange : row) {
                if (orange == FRESH_ORANGE) return false;
            }
        }
        return true;
    }

    private static Queue<Orange> allRottingOranges(int[][] grid) {
        final Queue<Orange> rottenOranges = new LinkedList<>();
        for (int row = 0 ; row < grid.length ; row++) {
            for (int column = 0 ; column < grid[0].length ; column++) {
                if (grid[row][column] == ROTTEN_ORANGE) {
                    rottenOranges.add(new Orange(row, column, 0));
                }
            }
        }
        return rottenOranges;
    }

    private static boolean isValidPosition(Orange orange, int[][] grid) {
        return orange.row >= 0 && orange.row < grid.length && orange.column >= 0 && orange.column < grid[0].length;
    }

    private static boolean isRotten(int[][] grid, Orange orange) {
        return grid[orange.row][orange.column] == ROTTEN_ORANGE;
    }

    private static boolean isEmptyCell(int[][] grid, Orange orange) {
        return grid[orange.row][orange.column] == EMPTY_CELL;
    }
}
