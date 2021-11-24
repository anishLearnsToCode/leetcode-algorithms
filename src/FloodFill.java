public class FloodFill {
    private int[][] image;
    private int height;
    private int width;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        height = image.length;
        width = image[0].length;
        if (image[sr][sc] != newColor) {
            colorPixel(sr, sc, image[sr][sc], newColor);
        }
        return image;
    }

    private void colorPixel(int row, int col, int oldColor, int newColor) {
        if (image[row][col] != newColor) {
            image[row][col] = newColor;
            if (row - 1 >= 0 && image[row - 1][col] == oldColor) colorPixel(row - 1, col, oldColor, newColor);
            if (col + 1 < width && image[row][col + 1] == oldColor) colorPixel(row, col + 1, oldColor, newColor);
            if (row + 1 < height && image[row + 1][col] == oldColor) colorPixel(row + 1, col, oldColor, newColor);
            if (col - 1 >= 0 && image[row][col - 1] == oldColor) colorPixel(row, col - 1, oldColor, newColor);
        }
    }
}
