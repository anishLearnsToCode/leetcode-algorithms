// https://leetcode.com/problems/rotate-image
// T: O(n ^ 2)
// S: O(1)

public class RotateImage {
    private static final class Point {
        private final int row;
        private final int column;

        private Point(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    public void rotate(int[][] matrix) {
        final int frames = (matrix.length + 1) / 2;
        for (int frame = 0 ; frame < frames ; frame++) {
            rotate90Degrees(matrix, frame);
        }
    }

    private void rotate90Degrees(int[][] matrix, int frame) {
        for (int i = 0 ; i < matrix.length - 2 * frame - 1 ; i++) {
            Point p1 = getCoordinates(frame, 0, matrix.length, i);
            int temp1 = get(matrix, p1), temp2;
            for (int k = 0 ; k < 4 ; k++) {
                Point p2 = getCoordinates(frame, (k + 1) % 4, matrix.length, i);
                temp2 = get(matrix, p2);
                set(matrix, p2, temp1);
                temp1 = temp2;
            }
        }
    }

    private int get(int[][] matrix, Point point) {
        return matrix[point.row][point.column];
    }

    private void set(int[][] matrix, Point point, int value) {
        matrix[point.row][point.column] = value;
    }

    private Point getCoordinates(int frame, int k, int size, int shift) {
        return switch (k) {
            case 0 -> new Point(frame, frame + shift);
            case 1 -> new Point(frame + shift, size - 1 - frame);
            case 2 -> new Point(size - 1 - frame, size - 1 - frame - shift);
            case 3 -> new Point(size - 1 - frame - shift, frame);
            default -> null;
        };
    }
}
