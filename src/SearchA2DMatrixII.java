// https://leetcode.com/problems/search-a-2d-matrix-ii
// T: O(m + n)
// S: O(1)

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int rows = matrix.length, columns = matrix[0].length;
        for (int column = columns - 1, row = 0 ; row < rows && column >= 0 ; ) {
            if (matrix[row][column] == target) return true;
            else if (matrix[row][column] < target) row++;
            else column--;
        }
        return false;
    }
}
