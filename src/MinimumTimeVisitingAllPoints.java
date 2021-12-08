public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        int minTime = 0;
        for (int index = 0 ; index < points.length - 1 ; index++) {
            minTime += Math.max(
                    Math.abs(points[index + 1][1] - points[index][1]),
                    Math.abs(points[index + 1][0] - points[index][0])
            );
        }
        return minTime;
    }
}
