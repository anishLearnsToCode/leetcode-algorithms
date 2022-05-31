// https://leetcode.com/problems/surrounded-regions
// T: O(m * n)
// S: O(m * n)

import java.util.HashSet;
import java.util.Set;

public class SurroundedRegions {
    private record Position(int row, int column) {
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            Position position = (Position) o;
            if (row != position.row) return false;
            return column == position.column;
        }

        @Override
        public int hashCode() {
            return 31 * row + column;
        }

        public Position top() {
            return new Position(row - 1, column);
        }

        public Position right() {
            return new Position(row, column + 1);
        }

        public Position bottom() {
            return new Position(row + 1, column);
        }

        public Position left() {
            return new Position(row, column - 1);
        }
    }

    public void solve(char[][] board) {
        final Set<Position> visited = new HashSet<>();
        final Set<Position> current = new HashSet<>();
        final int rows = board.length, columns = board[0].length;

        for (int row = 1 ; row < rows - 1 ; row++) {
            for (int column = 1 ; column < columns - 1 ; column++) {
                if (board[row][column] == 'O') {
                    final boolean isBorderRegion = markRegion(board, new Position(row, column), visited, current);
                    if (!isBorderRegion) {
                        captureRegion(board, current);
                    }
                    current.clear();
                }
            }
        }
    }

    private boolean markRegion(char[][] board, Position position, Set<Position> visited, Set<Position> region) {
        if (isInvalidPosition(board, position) || visited.contains(position) || isX(board, position)) return false;
        visited.add(position);
        region.add(position);
        boolean top = markRegion(board, position.top(), visited, region);
        boolean right = markRegion(board, position.right(), visited, region);
        boolean bottom = markRegion(board, position.bottom(), visited, region);
        boolean left = markRegion(board, position.left(), visited, region);
        return top || right || bottom || left || isBorderPosition(board, position);
    }

    private boolean isX(char[][] board, Position position) {
        return board[position.row][position.column] == 'X';
    }

    private boolean isBorderPosition(char[][] board, Position position) {
        return position.row == 0
                || position.row == board.length - 1
                || position.column == 0
                || position.column == board[0].length - 1;
    }

    private boolean isInvalidPosition(char[][] board, Position position) {
        return position.row < 0
                || position.row >= board.length
                || position.column < 0
                || position.column >= board[0].length;
    }

    private void captureRegion(char[][] board, Set<Position> positions) {
        for (Position position : positions) {
            board[position.row][position.column] = 'X';
        }
    }
}
