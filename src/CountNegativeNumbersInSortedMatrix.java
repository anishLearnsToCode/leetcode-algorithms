public class CountNegativeNumbersInSortedMatrix {
    public int countNegatives(int[][] grid) {
        final int rows = grid.length, columns = grid[0].length;
        int negativeNumbers = 0, negativeColumnIndex = columns;
        for (int[] row : grid) {
            negativeNumbers += columns;
            for (int column = 0 ; column < negativeColumnIndex ; column++) {
                if (row[column] < 0) {
                    negativeColumnIndex = column;
                    break;
                }
                negativeNumbers--;
            }
        }
        return negativeNumbers;
    }
}
