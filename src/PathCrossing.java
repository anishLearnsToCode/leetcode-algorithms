import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PathCrossing {
    public boolean isPathCrossing(String path) {
        Set<Point> visitedPoints = new HashSet<>();
        visitedPoints.add(new Point(0, 0));
        for (int index = 0, x = 0, y = 0 ; index < path.length() ; index++) {
            switch (path.charAt(index)) {
                case 'N' -> y++;
                case 'E' -> x++;
                case 'S' -> y--;
                case 'W' -> x--;
            }
            Point newPosition = new Point(x, y);
            if (visitedPoints.contains(newPosition)) return true;
            visitedPoints.add(newPosition);
        }
        return false;
    }

    private static final class Point {
        private final int x;
        private final int y;

        private Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (Point) obj;
            return this.x == that.x &&
                    this.y == that.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
