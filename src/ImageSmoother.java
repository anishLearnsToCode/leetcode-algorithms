public class ImageSmoother {
    public int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];
        int sum, count, rows = img.length, columns = img[0].length;
        for (int row = 0 ; row < rows; row++) {
            for (int column = 0 ; column < columns ; column++) {
                sum = count = 0;
                for (int k_row = row == 0 ? row : row - 1 ; k_row <= (row == rows - 1 ? row : row + 1) ; k_row++) {
                    for (int k_column = column == 0 ? column : column - 1 ; k_column <= (column == columns - 1 ? column : column + 1) ; k_column++, count++) {
                        sum += img[k_row][k_column];
                    }
                }
                result[row][column] = sum / count;
            }
        }
        return result;
    }
}
