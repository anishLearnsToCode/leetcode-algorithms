import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        final int rows = grid.length, columns = grid[0].length;
        final List<List<Integer>> result = getGrid(rows, columns);
        final int rowOperations = k / columns;
        for (int column = 0 ; column < columns ; column++) {
            int rowShifts = (rowOperations + (k - columns * rowOperations - 1 >= column ? 1 : 0)) % rows;
            int columnIndex = (columns + column - (k % columns)) % columns;
            for (int row = 0 ; row < rows ; row++) {
                result.get(row).set(column, grid[(rows + row - rowShifts) % rows][columnIndex]);
            }
        }
        return result;
    }

    private static List<List<Integer>> getGrid(int rows, int columns) {
        List<List<Integer>> result = new ArrayList<>(rows);
        for (int row = 0 ; row < rows ; row++) {
            result.add(getList(columns));
        }
        return result;
    }

    private static List<Integer> getList(int size) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0 ; i < size ; i++) {
            result.add(0);
        }
        return result;
    }
}
