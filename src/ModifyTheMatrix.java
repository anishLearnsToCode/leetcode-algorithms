// https://leetcode.com/problems/modify-the-matrix
// T: O(m * n)
// S: O(1)

public class ModifyTheMatrix {
    public int[][] modifiedMatrix(int[][] matrix) {
        final int rows = matrix.length, columns = matrix[0].length;

        for (int column = 0 ; column < columns ; column++) {
            final int maxValueColumn = getMaxInColumn(matrix, column);
            replaceAllNegative1With(matrix, column, maxValueColumn);
        }

        return matrix;
    }

    private static int getMaxInColumn(int[][] matrix, int column) {
        int maxValue = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            maxValue = Math.max(maxValue, row[column]);
        }
        return maxValue;
    }

    private static void replaceAllNegative1With(int[][] matrix, int column, int value) {
        for (int row = 0 ; row < matrix.length ; row++) {
            if (matrix[row][column] == -1) {
                matrix[row][column] = value;
            }
        }
    }
}
