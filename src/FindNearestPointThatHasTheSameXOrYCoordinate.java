public class FindNearestPointThatHasTheSameXOrYCoordinate {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int minDistance = Integer.MAX_VALUE, minIndex = -1;
        for (int index = 0 ; index < points.length ; index++) {
            int[] point = points[index];
            if (point[0] == x || point[1] == y) {
                int distance = manhattanDistance(x, y, point);
                if (distance < minDistance) {
                    minDistance = distance;
                    minIndex = index;
                }
            }
        }
        return minIndex;
    }

    private int manhattanDistance(int x, int y, int[] point) {
        return Math.abs(x - point[0]) + Math.abs(y - point[1]);
    }
}
