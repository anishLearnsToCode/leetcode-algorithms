// https://leetcode.com/problems/unique-paths-ii
// T: O(m * n)
// S: O(n)

public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int rows = obstacleGrid.length, columns = obstacleGrid[0].length;
        if (obstacleGrid[rows - 1][columns - 1] == 1) return 0;
        final int[][] memory = getMemoryTable(obstacleGrid);

        int i = 0;
        for (int row = rows - 2 ; row >= 0; row--, i ^= 1) {
            memory[i][columns - 1] = memory[i ^ 1][columns - 1] & (obstacleGrid[row][columns - 1] ^ 1);
            for (int column = columns - 2 ; column >= 0 ; column--) {
                if (obstacleGrid[row][column] == 1) {
                    memory[i][column] = 0;
                } else {
                  memory[i][column] = memory[i ^ 1][column] + memory[i][column + 1];
                }
            }
        }

        return memory[i ^ 1][0];
    }

    private int[][] getMemoryTable(int[][] obstacles) {
        final int rows = obstacles.length, columns = obstacles[0].length;
        final int[][] memory = new int[2][columns];
        memory[1][columns - 1] = 1;
        for (int column = columns - 2 ; column >= 0 ; column--) {
            memory[1][column] = memory[1][column + 1] & (obstacles[rows - 1][column] ^ 1);
        }
        return memory;
    }
}
