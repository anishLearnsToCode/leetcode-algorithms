// https://leetcode.com/problems/knight-probability-in-chessboard
// T: O(n^2 * k)
// S: O(n^2)

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
                return n - index - 1;
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

    private static final Map<Position, List<Movement>> allowedMovements = new HashMap<>();
    private static final Map<State, Double> results = new HashMap<>();
    private static int[][] validMoves;

    public static double knightProbability(int n, int k, int row, int column) {
        computeValidMovements(n);
        return getKnightProbability(n, k, new Position(row, column, n));
    }

    private static double getKnightProbability(int n, int k, Position position) {
        if (k == 0) return 1;

        position.normalize();
        State state = new State(n, k, position);
        if (results.containsKey(state)) return results.get(state);

        if (k == 1) {
            double answer = ((double) validMoves(position)) / 8;
            results.put(state, answer);
            return answer;
        }

        double sumOfProbabilities = 0;
        for (Movement movement : allowedMovements.get(position)) {
            Position newPosition = position.apply(movement);
            sumOfProbabilities += getKnightProbability(n, k - 1, newPosition);
        }
        double answer = sumOfProbabilities / 8;
        results.put(state, answer);
        return answer;
    }

    private static void computeValidMovements(int n) {
        for (int row = 0 ; row < (n + 1) / 2 ; row++) {
            for (int column = row ; column < (n + 1) / 2 ; column++) {
                Position position = new Position(row, column, n);
                allowedMovements.put(position, knightMovementsAt(position));
            }
        }
        fillValidMovesTable(n);
    }

    private static void fillValidMovesTable(int n) {
        final int length = (n + 1) / 2;
        validMoves = new int[length][length];
        for (int row = 0 ; row < length ; row++) {
            for (int column = row ; column < length ; column++) {
                validMoves[row][column] = allowedMovements.get(new Position(row, column, n)).size();
            }
        }
    }

    private static List<Movement> knightMovementsAt(Position position) {
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

    private static boolean isValidIndices(int row, int column, int n) {
        return row >= 0
                && row < n
                && column >= 0
                && column < n;
    }

    private static int validMoves(Position position) {
        return validMoves[position.row][position.column];
    }
}
