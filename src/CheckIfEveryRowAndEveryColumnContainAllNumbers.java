import java.util.HashSet;
import java.util.Set;

public class CheckIfEveryRowAndEveryColumnContainAllNumbers {
    private int n;

    public boolean checkValid(int[][] matrix) {
        this.n = matrix.length;
        return checkAllRows(matrix) && checkAllColumns(matrix);
    }

    private boolean checkAllRows(int[][] matrix) {
        for (int[] row : matrix) {
            if (!isRowValid(row)) return false;
        }
        return true;
    }

    private boolean isRowValid(int[] row) {
        final Set<Integer> numbers = new HashSet<>();
        for (int element: row) {
            if (element <= 0 || element > n) return false;
            if (numbers.contains(element)) return false;
            numbers.add(element);
        }
        return true;
    }

    private boolean checkAllColumns(int[][] matrix) {
        for (int column = 0 ; column < n ; column++) {
            final Set<Integer> numbers = new HashSet<>();
            for (int row = 0 ; row < n ; row++) {
                int element = matrix[row][column];
                if (element < 0 || element > n) return false;
                if (numbers.contains(element)) return false;
                numbers.add(element);
            }
        }
        return true;
    }
}
