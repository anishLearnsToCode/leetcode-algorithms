// https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points
// T: O(N log(N))
// S: O(log(N))

import java.util.Arrays;
import java.util.Comparator;

public class WidestVerticalAreaBetweenTwoPointsContainingNoPoints {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int maxVerticalArea = 0;
        for (int i = 0 ; i < points.length - 1; i++) {
            maxVerticalArea = Math.max(maxVerticalArea, points[i + 1][0] - points[i][0]);
        }
        return maxVerticalArea;
    }
}
