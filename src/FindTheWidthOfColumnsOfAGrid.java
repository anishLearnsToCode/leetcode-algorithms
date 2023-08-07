// https://leetcode.com/problems/find-the-width-of-columns-of-a-grid
// m: rows in matrix
// n: columns in matrix
// T: O(m * n)
// S: O(n)

public class FindTheWidthOfColumnsOfAGrid {
    public int[] findColumnWidth(int[][] grid) {
        final int columns = grid[0].length;
        final int[] result = new int[columns];
        for (int column = 0 ; column < columns ; column++) {
            int maxLen = 0;
            for (int[] row : grid) {
                maxLen = Math.max(maxLen, (String.valueOf(row[column])).length());
            }
            result[column] = maxLen;
        }
        return result;
    }
}
