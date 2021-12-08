public class CellsWithOddValuesInMatrix {
    public int oddCells(int m, int n, int[][] operations) {
        final byte[] rowState = new byte[m];
        final byte[] columnState = new byte[n];
        for (int[] operation : operations) {
            rowState[operation[0]] ^= 1;
            columnState[operation[1]] ^= 1;
        }
        int oddElements = 0;
        final int shiftedColumns = sum(columnState);
        for (int row : rowState) {
            oddElements += row == 0 ? shiftedColumns : n - shiftedColumns;
        }
        return oddElements;
    }

    private int sum(byte[] array) {
        int sum = 0;
        for (byte element : array) sum += element;
        return sum;
    }
}
