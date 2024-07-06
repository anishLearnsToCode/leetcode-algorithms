// https://leetcode.com/problems/maximum-area-of-longest-diagonal-rectangle
// T: O(N)
// S: O(1)

public class MaximumAreaOfLongestDiagonalRectangle {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0, maxDiagonal = 0;

        for (final int[] rectangle : dimensions) {
            final int diagonal = getDiagonal(rectangle);
            final int area = getArea(rectangle);

            if (diagonal > maxDiagonal) {
                maxDiagonal = diagonal;
                maxArea = area;
            } else if (diagonal == maxDiagonal) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private static int getArea(int[] rectangle) {
        return rectangle[0] * rectangle[1];
    }

    private static int getDiagonal(int[] rectangle) {
        return rectangle[0] * rectangle[0] + rectangle[1] * rectangle[1];
    }
}
