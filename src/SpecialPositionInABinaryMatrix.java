// https://leetcode.com/problems/special-positions-in-a-binary-matrix
// T: O(n * m)
// S: O(n + m)

import java.util.Arrays;

public class SpecialPositionInABinaryMatrix {
    public int numSpecial(int[][] matrix) {
        final int[] rowSum = getRowSum(matrix);
        final ColumnSumData columnSumData = getColumnSum(matrix);
        final int[] columnSumOneRowIndex = columnSumData.oneIndex;
        final int[] columnSum = columnSumData.sum;
        int specialPositions = 0;
        for (int i = 0 ; i < columnSum.length ; i++) {
            if (columnSum[i] == 1 && rowSum[columnSumOneRowIndex[i]] == 1) {
                specialPositions++;
            }
        }
        return specialPositions;
    }

    private int[] getRowSum(int[][] matrix) {
        final int[] sum = new int[matrix.length];
        for (int i = 0 ; i < sum.length ; i++) {
            sum[i] = Arrays.stream(matrix[i]).sum();
        }
        return sum;
    }

    private ColumnSumData getColumnSum(int[][] matrix) {
        final int[] sum = new int[matrix[0].length];
        final int[] indexes = new int[sum.length];
        for (int i = 0 ; i < sum.length ; i++) {
            for (int row = 0 , index = 0 ; row < matrix.length ; row++) {
                sum[i] += matrix[row][i];
                if (matrix[row][i] == 1) indexes[i] = row;
            }
        }
        return new ColumnSumData(sum, indexes);
    }

    private static final class ColumnSumData {
        private final int[] sum;
        private final int[] oneIndex;

        private ColumnSumData(int[] sum, int[] oneIndex) {
            this.sum = sum;
            this.oneIndex = oneIndex;
        }
    }
}
