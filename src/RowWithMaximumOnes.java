// https://leetcode.com/problems/row-with-maximum-ones
// m: number of rows in matrix
// n: number of columns in matrix
// T: O(m * n)
// S: O(m * n)

public class RowWithMaximumOnes {
    public int[] rowAndMaximumOnes(int[][] matrix) {
        final int rows = matrix.length, columns = matrix[0].length;
        int maxOnes = 0, maxRow = 0;
        for (int row = 0 ; row < rows ; row++) {
            final int onesCount = getOnesCount(matrix[row]);
            if (onesCount > maxOnes) {
                maxOnes = onesCount;
                maxRow = row;
            }
        }
        return new int[] { maxRow, maxOnes };
    }

    private int getOnesCount(int[] array) {
        int count = 0;
        for (int element : array) {
            if (element == 1) count++;
        }
        return count;
    }
}
