import java.util.Objects;

public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        Position p1 = Position.from(points[0]);
        Position p2 = Position.from(points[1]);
        Position p3 = Position.from(points[2]);
        if (p1.equals(p2) || p2.equals(p3) || p3.equals(p1)) return false;
        if (p1.x == p2.x) return p3.x != p2.x;
        if (p2.x == p3.x) return true;
        return (p2.y - p1.y) * (p3.x - p2.x) != (p3.y - p2.y) * (p2.x - p1.x);
    }

    private final static class Position {
        private final int x;
        private final int y;

        private static Position from(int[] array){
            return new Position(array[0], array[1]);
        }

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
