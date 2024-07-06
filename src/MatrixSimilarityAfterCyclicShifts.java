// https://leetcode.com/problems/matrix-similarity-after-cyclic-shifts
// m = rows(mat), n = columns(mat)
// T: O(m * n)
// S: O(1)

public class MatrixSimilarityAfterCyclicShifts {
    public boolean areSimilar(int[][] matrix, int k) {
        final int rows = matrix.length, columns = matrix[0].length;

        if (k % columns == 0) {
            return true;
        }

        for (int i = 0 ; i < rows ; i += 2) {
            if (!isValidLeftShift(matrix[i], k)) {
                return false;
            }
        }

        for (int i = 1 ; i < rows ; i += 2) {
            if (!isValidRightShift(matrix[i], k)) {
                return false;
            }
        }

        return true;
    }

    private static boolean isValidRightShift(int[] row, int shift) {
        int shiftLength = shift % row.length;
        for (int i = 0, k = 0 ; k < row.length ; i = (i + 1) % row.length, k++) {
            if (row[i] != row[(i + shiftLength) % row.length]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidLeftShift(int[] row, int shift) {
        final int shiftLength = shift % row.length;
        for (int i = 0, k = 0 ; k < row.length ; i = (i + 1) % row.length, k++) {
            if (row[i] != row[(i - shiftLength + row.length) % row.length]) {
                return false;
            }
        }
        return true;
    }
}
