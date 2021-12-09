import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersInAMatrix {
    public List<Integer> luckyNumbers (int[][] matrix) {
        final int rows = matrix.length, columns = matrix[0].length;
        final List<Integer> luckyNumbers = new ArrayList<>();
        int[] columnMax = getMaxOfColumns(matrix);
        for (int row = 0 ; row < rows ; row++) {
            RowMin rowMin = RowMin.from(matrix[row]);
            if (rowMin.min == columnMax[rowMin.index]) {
                luckyNumbers.add(rowMin.min);
            }
        }
        return luckyNumbers;
    }

    private static final class RowMin {
        private final int index;
        private final int min;

        private RowMin(int index, int min) {
            this.index = index;
            this.min = min;
        }

        private static RowMin from(int[] row) {
            int minIndex = 0, min = row[0];
            for (int i = 1; i < row.length; i++) {
                if (row[i] < min) {
                    minIndex = i;
                    min = row[i];
                }
            }
            return new RowMin(minIndex, min);
        }
    }

    private int[] getMaxOfColumns(int[][] grid) {
        final int rows = grid.length, columns = grid[0].length;
        final int[] columnsMax = new int[columns];
        for (int[] row : grid) {
            for (int column = 0 ; column < columns ; column++) {
                columnsMax[column] = Math.max(columnsMax[column], row[column]);
            }
        }
        return columnsMax;
    }
}
