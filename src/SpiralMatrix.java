import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        final List<Integer> result = new ArrayList<>();
        final int rows = matrix.length, columns = matrix[0].length, elements = rows * columns;
        for (int i = 0, top = 0, bottom = rows, left = 0, right = columns ; ; ) {
            for (int row = top, column = left ; column < right ; column++, i++) {
                result.add(matrix[row][column]);
            }
            top++;
            if (i == elements) break;
            for (int row = top, column = right - 1 ; row < bottom ; row++, i++) {
                result.add(matrix[row][column]);
            }
            right--;
            if (i == elements) break;
            for (int row = bottom - 1, column = right - 1 ; column >= left ; column--, i++) {
                result.add(matrix[row][column]);
            }
            bottom--;
            if (i == elements) break;
            for (int row = bottom - 1, column = left ; row >= top ; row--, i++) {
                result.add(matrix[row][column]);
            }
            left++;
            if (i == elements) break;
        }
        return result;
    }
}
