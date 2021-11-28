public class SurfaceAreaOf3DShapes {
    public int surfaceArea(int[][] grid) {
        final int rows = grid.length, columns = grid[0].length;
        int surfaceArea = 0;
        for (int row = 0 ; row < rows ; row++) {
            for (int column = 0 ; column < columns ; column++) {
                surfaceArea += (grid[row][column] > 0 ? 2 : 0)
                        + (column + 1 < columns ? Math.abs(grid[row][column] - grid[row][column + 1]) : grid[row][column])
                        + (row + 1 < rows ? Math.abs(grid[row][column] - grid[row + 1][column]) : grid[row][column])
                        + (row == 0 ? grid[row][column] : 0)
                        + (column == 0 ? grid[row][column] : 0);
            }
        }
        return surfaceArea;
    }
}
