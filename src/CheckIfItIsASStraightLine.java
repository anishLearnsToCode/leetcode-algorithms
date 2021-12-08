public class CheckIfItIsASStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        for (int i = 0 ; i < coordinates.length - 2 ; i++) {
            if (!isOnStraightLine(coordinates[i], coordinates[i + 1], coordinates[i + 2])) {
                return false;
            }
        }
        return true;
    }

    private boolean isOnStraightLine(int[] p1, int[] p2, int[] p3) {
        if (p1[0] == p2[0] && p2[0] == p3[0]) return true;
        if (p1[1] == p2[1] && p2[1] == p3[1]) return true;
        return (p2[1] - p1[1]) * (p3[0] - p2[0]) == (p3[1] - p2[1]) * (p2[0] - p1[0]);
    }
}
