import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightProbabilityInChessboard {
    static class Position {
        private final int n;
        private int row;
        private int column;

        Position(int row, int column, int n) {
            this.n = n;
            this.row = row;
            this.column = column;

        }

        private void normalize() {
            row = normalize(row);
            column = normalize(column);
            if (row > column) {
                int temp = row;
                row = column;
                column = temp;
            }
        }

        private int normalize(int index) {
            if (index >= (n + 1) / 2) {
                return n - index;
            }
            return index;
        }

        private Position apply(Movement movement) {
            return switch (movement) {
                case TOP_LEFT -> new Position(row - 2, column - 1, n);
                case TOP_RIGHT -> new Position(row - 2, column + 1, n);
                case RIGHT_TOP -> new Position(row - 1, column + 2, n);
                case RIGHT_BOTTOM -> new Position(row + 1, column + 2, n);
                case BOTTOM_RIGHT -> new Position(row + 2, column + 1, n);
                case BOTTOM_LEFT -> new Position(row + 2, column - 1, n);
                case LEFT_BOTTOM -> new Position(row + 1, column - 2, n);
                case LEFT_TOP -> new Position(row - 1, column - 2, n);
            };
        }

        private boolean isValid() {
            return row >= 0
                    && row < n
                    && column >= 0
                    && column < n;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Position other = (Position) o;
            if (row != other.row) return false;
            return column == other.column;
        }

        @Override
        public int hashCode() {
            return 31 * row + column;
        }
    }

    private record State(int n, int k, Position position) { }

    private enum Movement {
        TOP_LEFT,
        TOP_RIGHT,
        RIGHT_TOP,
        RIGHT_BOTTOM,
        BOTTOM_RIGHT,
        BOTTOM_LEFT,
        LEFT_TOP,
        LEFT_BOTTOM
    }

    private final Map<Position, List<Movement>> allowedMovements = new HashMap<>();
    private final Map<State, Double> results = new HashMap<>();

    public double knightProbability(int n, int k, int row, int column) {
        computeValidMovements(n);
        return getKnightProbability(n, k, new Position(row, column, n));
    }

    private double getKnightProbability(int n, int k, Position position) {
        if (!position.isValid()) return 0;
        if (k == 0) return 1;

        position.normalize();
        State state = new State(n, k, position);
        if (results.containsKey(state)) return results.get(state);

        if (k == 1) {
            double answer = ((double) validMoves(position)) / 8;
            results.put(state, answer);
            return answer;
        }

        int sumOfProbabilities = 0;
        for (Movement movement : allowedMovements.get(position)) {
            Position newPosition = position.apply(movement);
            sumOfProbabilities += getKnightProbability(n, k - 1, newPosition);
        }
        double answer = ((double) sumOfProbabilities) / 8;
        results.put(state, answer);
        return answer;
    }

    private void computeValidMovements(int n) {
        for (int row = 0 ; row < (n + 1) / 2 ; row++) {
            for (int column = row ; column < (n + 1) / 2 ; column++) {
                Position position = new Position(row, column, n);
                allowedMovements.put(position, knightMovementsAt(position));
            }
        }
    }

    private List<Movement> knightMovementsAt(Position position) {
        final List<Movement> movements = new ArrayList<>();
        if (isValidIndices(position.row - 2, position.column - 1, position.n)) movements.add(Movement.TOP_LEFT);
        if (isValidIndices(position.row - 2, position.column + 1, position.n)) movements.add(Movement.TOP_RIGHT);
        if (isValidIndices(position.row - 1, position.column + 2, position.n)) movements.add(Movement.RIGHT_TOP);
        if (isValidIndices(position.row + 1, position.column + 2, position.n)) movements.add(Movement.RIGHT_BOTTOM);
        if (isValidIndices(position.row + 2, position.column + 1, position.n)) movements.add(Movement.BOTTOM_RIGHT);
        if (isValidIndices(position.row + 2, position.column - 1, position.n)) movements.add(Movement.BOTTOM_LEFT);
        if (isValidIndices(position.row + 1, position.column - 2, position.n)) movements.add(Movement.LEFT_BOTTOM);
        if (isValidIndices(position.row - 1, position.column - 2, position.n)) movements.add(Movement.LEFT_TOP);
        return movements;
    }

    private boolean isValidIndices(int row, int column, int n) {
        return row >= 0
                && row < n
                && column >= 0
                && column < n;
    }

    private int validMoves(Position position) {
        return allowedMovements.get(position).size();
    }
}
