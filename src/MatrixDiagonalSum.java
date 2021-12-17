// https://leetcode.com/problems/matrix-diagonal-sum
// T: O(N)
// S: O(1)

public class MatrixDiagonalSum {
    public int diagonalSum(int[][] matrix) {
        return sumPrimaryDiagonal(matrix) + sumSecondaryDiagonal(matrix) -
                ((matrix.length & 1) == 1 ? matrix[matrix.length / 2][matrix.length / 2] : 0);
    }

    private int sumPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0 ; i < matrix.length ; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    private int sumSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0 ; i < matrix.length ; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }
}
