import java.util.Arrays;

public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        final int totalDistance = Arrays.stream(distance).sum();
        final int path1 = getDistance(distance, start, destination);
        return Math.min(path1, totalDistance - path1);
    }

    private int getDistance(int[] distances, int start, int end) {
        int distance = 0;
        for (int i = start ; i != end ; i = (i + 1) % distances.length) {
            distance += distances[i];
        }
        return distance;
    }
}
