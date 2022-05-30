// https://leetcode.com/problems/triangle
// T: O(n) where n elements in triangle
// S: O(1)

import java.util.List;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        final int rows = triangle.size();
        List<Integer> previousRow = triangle.get(0);

        for (int row = 1 ; row < rows ; row++) {
            final List<Integer> currentRow = triangle.get(row);
            for (int column = 0 ; column < row + 1 ; column++) {
                if (column == 0) currentRow.set(column, currentRow.get(column) + previousRow.get(0));
                else if (column == row) currentRow.set(column, currentRow.get(column) + previousRow.get(row - 1));
                else currentRow.set(
                        column,
                        currentRow.get(column) + Math.min(previousRow.get(column - 1), previousRow.get(column))
                    );
            }
            previousRow = currentRow;
        }

        return minOfLastRow(triangle);
    }

    private int minOfLastRow(List<List<Integer>> triangle) {
        return min(triangle.get(triangle.size() - 1));
    }

    private int min(List<Integer> array) {
        return array.stream().min(Integer::compareTo).get();
    }
}
