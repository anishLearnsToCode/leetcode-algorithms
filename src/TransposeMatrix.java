public class TransposeMatrix {
    public int[][] transpose(int[][] matrix) {
        final int rows = matrix.length, columns = matrix[0].length;
        final int[][] result = new int[columns][rows];

        for (int row = 0 ; row < rows ; row++) {
            for (int column = 0 ; column < columns ; column++) {
                result[column][row] = matrix[row][column];
            }
        }

        return result;
    }
}
