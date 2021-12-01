import java.util.LinkedList;
import java.util.Queue;

public class MatrixCellsInDistanceOrder {
    public int[][] allCellsDistOrder(final int rows, final int columns, int rCenter, int cCenter) {
        int[][] result = new int[rows * columns][2];
        final Queue<int[]> positions = new LinkedList<>();
        final boolean[][] visited = new boolean[rows][columns];
        positions.add(new int[] {rCenter, cCenter});
        int k = 0, row, column;
        while (!positions.isEmpty()) {
            int[] position = positions.poll();
            row = position[0];
            column = position[1];
            if (row < 0 || row >= rows || column < 0 || column >= columns) continue;
            if (visited[row][column]) continue;
            visited[row][column] = true;
            result[k++] = position;
            positions.add(new int[] {row - 1, column});
            positions.add(new int[] {row, column + 1});
            positions.add(new int[] {row + 1, column});
            positions.add(new int[] {row, column - 1});
        }
        return result;
    }
}
