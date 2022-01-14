// https://leetcode.com/problems/set-matrix-zeroes/
// T: O(m * n)
// S: O(1)

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        final int rows = matrix.length, columns = matrix[0].length;
        boolean firstColumnIsZero = false;

        for (int row = 0 ; row < rows ; row++) {
            if (matrix[row][0] == 0) firstColumnIsZero = true;
            for (int column = 1 ; column < columns ; column++) {
                if (matrix[row][column] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }

        for (int column = columns - 1 ; column >= 1 ; column--) {
            if (matrix[0][column] == 0) {
                markColumn0(matrix, column);
            }
        }

        for (int row = rows - 1 ; row >= 0 ; row--) {
            if (matrix[row][0] == 0) {
                markRow0(matrix, row);
            }
        }

        if (firstColumnIsZero) markColumn0(matrix, 0);
    }

    private void markRow0(int[][] matrix, int row) {
        for (int column = 0 ; column < matrix[0].length ; column++) {
            matrix[row][column] = 0;
        }
    }

    private void markColumn0(int[][] matrix, int column) {
        for (int row = 0 ; row < matrix.length ; row++) {
            matrix[row][column] = 0;
        }
    }
}
