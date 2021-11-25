public class ToeplitzMatrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        final int rows = matrix.length, columns = matrix[0].length;
        int current;
        for (int column = 0 ; column < columns ; column++) {
            current = matrix[0][column];
            for (int row = 1 ; row < rows && column + row < columns ; row++) {
                if (matrix[row][column + row] != current) return false;
            }
        }
        for (int row = 1 ; row < rows - 1 ; row++) {
            current = matrix[row][0];
            for (int column = 1 ; column < columns && row + column < rows ; column++) {
                if (matrix[row + column][column] != current) return false;
            }
        }
        return true;
    }
}
