public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int row = 0 ; row < grid.length ; row++) {
            for (int column = 0 ; column < grid[row].length ; column++) {
                if (grid[row][column] == 1) {
                    perimeter += 4 - surroundedBy(grid, row, column);
                }
            }
        }
        return perimeter;
    }

    private static int surroundedBy(int[][] grid, int row, int column) {
        int surrounded = 0;
        if (row - 1 >= 0 && grid[row - 1][column] == 1) {
            surrounded++;
        }
        if (column + 1 < grid[0].length && grid[row][column + 1] == 1) {
            surrounded++;
        }
        if (row + 1 < grid.length && grid[row + 1][column] == 1) {
            surrounded++;
        }
        if (column - 1 >= 0 && grid[row][column - 1] == 1) {
            surrounded++;
        }
        return surrounded;
    }
}
