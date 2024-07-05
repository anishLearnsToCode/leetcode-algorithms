// https://leetcode.com/problems/points-that-intersect-with-cars
// T: O(|nums| + |cars|)
// S: O(|cars|)

import java.util.List;

public class PointsThatIntersectWithCars {
    public int numberOfPoints(List<List<Integer>> nums) {
        final int[] points = new int[101];
        int count = 0;

        for (final List<Integer> car : nums) {
            points[car.get(0) - 1]++;
            points[car.get(1)]--;
        }

        for (int i = 0, overlap = 0 ; i < points.length ; i++) {
            overlap += points[i];
            if (overlap > 0) {
                count++;
            }
        }
        return count;
    }
}
