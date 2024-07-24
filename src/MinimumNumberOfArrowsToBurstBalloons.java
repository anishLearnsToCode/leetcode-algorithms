// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
// T: O(NlogN)
// S: O(logN)

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int arrows = 1, endPoint = points[0][1];
        for (int[] p: points) {
            if (endPoint < p[0]) {
                arrows++;
                endPoint = p[1];
            }
        }

        return arrows;
    }
}
