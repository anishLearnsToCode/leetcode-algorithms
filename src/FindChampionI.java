// https://leetcode.com/problems/find-champion-i
// T: O(|grid.length| ^ 2)
// S: O(1)

public class FindChampionI {
    public int findChampion(int[][] grid) {
        for (int row = 0 ; row < grid.length ; row++) {
            if (isChampion(grid, row)) {
                return row;
            }
        }
        return -1;
    }

    private static boolean isChampion(int[][] grid, int row) {
        for (int i = 0 ; i < grid.length ; i++) {
            if (i == row) {
                continue;
            }
            if (grid[row][i] == 0) {
                return false;
            }
        }
        return true;
    }
}
