// https://leetcode.com/problems/number-of-islands
// T: O(m * n)
// T: O(m * n)

public class NumberOfIslands {
    private static final char VISITED = '0';
    private static final char ISLAND = '1';

    public int numIslands(char[][] grid) {
        final int rows = grid.length, columns = grid[0].length;
        int islands = 0;

        for (int row = 0 ; row < rows ; row++) {
            for (int column = 0 ; column < columns ; column++) {
                if (isIsland(grid[row][column])) {
                    islands++;
                    markIslandAsSeen(grid, row, column);
                }
            }
        }

        return islands;
    }

    private boolean isIsland(char c) {
        return c == ISLAND;
    }

    private void markIslandAsSeen(char[][] grid, int row, int column) {
        if (!isValidPosition(grid, row, column) || !isIsland(grid[row][column])) return;
        markVisited(grid, row, column);
        markIslandAsSeen(grid, row - 1, column);
        markIslandAsSeen(grid, row, column + 1);
        markIslandAsSeen(grid, row + 1, column);
        markIslandAsSeen(grid, row, column - 1);
    }

    private boolean isValidPosition(char[][] grid, int row, int column) {
        return row >= 0
                && row < grid.length
                && column >= 0
                && column < grid[0].length;
    }

    private boolean alreadyVisited(char c) {
        return c == VISITED;
    }

    private void markVisited(char[][] grid, int row, int column) {
        grid[row][column] = VISITED;
    }
}
