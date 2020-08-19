import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        int boomerangs = 0;
        Map<Integer, Integer> distances = new HashMap<>();

        for (int i = 0; i < points.length; i++) {
            for (int j = 0 ; j < points.length; j++) {
                if (i == j) {
                    continue;
                }

                int distance = getDistance(points[i], points[j]);
                distances.put(distance, distances.getOrDefault(distance, 0) + 1);
            }

            for (int frequency : distances.values()) {
                boomerangs += frequency * (frequency - 1);
            }
            distances.clear();
        }

        return boomerangs;
    }

    private int getDistance(int[] point1, int[] point2) {
        int x_diff = point1[0] - point2[0];
        int y_diff = point1[1] - point2[1];
        return x_diff * x_diff + y_diff * y_diff;
    }
}
