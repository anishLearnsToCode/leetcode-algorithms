import java.util.Arrays;

public class ProjectionAreaOf3DShapes {
    public int projectionArea(int[][] grid) {
        int area = 0;
        final int n = grid.length;

        // z axis
        for (int row = 0 ; row < n  ; row++) {
            for(int column = 0 ; column < n ; column++) {
                area += grid[row][column] > 0 ? 1 : 0;
            }
        }

        // x axis
        for (int[] row : grid) {
            area += Arrays.stream(row).max().getAsInt();
        }

        // y axis
        for (int column = 0 ; column < n ; column++) {
            int columnMax = 0;
            for (int row = 0 ; row < n ; row++) columnMax = Math.max(columnMax, grid[row][column]);
            area += columnMax;
        }

        return area;
    }
}
