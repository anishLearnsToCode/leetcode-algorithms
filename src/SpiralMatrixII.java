// https://leetcode.com/problems/spiral-matrix-ii
// T: O(n^2)
// S: O(n^2)

public class SpiralMatrixII {
  public int[][] generateMatrix(int n) {
    final int[][] matrix = new int[n][n];
    final int rows = matrix.length, columns = matrix[0].length, elements = rows * columns;

    for (int i = 0, top = 0, bottom = rows, left = 0, right = columns, k = 1 ; ; ) {
      for (int row = top, column = left ; column < right ; column++, i++) {
        matrix[row][column] = k++;
      }
      top++;
      if (i == elements) break;
      for (int row = top, column = right - 1 ; row < bottom ; row++, i++) {
        matrix[row][column] = k++;
      }
      right--;
      if (i == elements) break;
      for (int row = bottom - 1, column = right - 1 ; column >= left ; column--, i++) {
        matrix[row][column] = k++;
      }
      bottom--;
      if (i == elements) break;
      for (int row = bottom - 1, column = left ; row >= top ; row--, i++) {
        matrix[row][column] = k++;
      }
      left++;
      if (i == elements) break;
    }
    return matrix;
  }
}
