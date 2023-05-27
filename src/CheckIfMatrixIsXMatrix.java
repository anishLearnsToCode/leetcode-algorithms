// https://leetcode.com/problems/check-if-matrix-is-x-matrix
// T: O(n * n)
// S: O(1)

public class CheckIfMatrixIsXMatrix {
    public boolean checkXMatrix(int[][] grid) {
        for (int row = 0 ; row < grid.length ; row++) {
            for (int column = 0 ; column < grid.length ; column++) {
                if (isDiagonalCell(row, column, grid.length)) {
                    if (grid[row][column] == 0) return false;
                } else if (grid[row][column] != 0) return false;
            }
        }
        return true;
    }

    private boolean isDiagonalCell(int row, int column, int length) {
        return row == column || column == length - row - 1;
    }
}
