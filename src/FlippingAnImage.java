public class FlippingAnImage {
    public int[][] flipAndInvertImage(int[][] image) {
        final int rows = image.length, columns = image[0].length;
        int temp;

        for (int row = 0 ; row < rows ; row++) {
            for (int column = 0 ; column < (columns + 1) / 2 ; column++) {
                temp = image[row][column] ^ 1;
                image[row][column] = image[row][columns - column - 1] ^ 1;
                image[row][columns - column - 1] = temp;
            }
        }

        return image;
    }
}
