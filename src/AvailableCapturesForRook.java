public class AvailableCapturesForRook {
    private static final class Position {
        private final int row;
        private final int column;

        private Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    private static final char ROOK = 'R';
    private static final char BISHOP = 'B';
    private static final char PAWN = 'p';

    public int numRookCaptures(char[][] board) {
        Position rookPosition = getPosition(board, ROOK);
        return (canCapturePawnInNorth(board, rookPosition) ? 1 : 0) +
                (canCapturePawnInWest(board, rookPosition) ? 1 : 0) +
                (canCapturePawnInSouth(board, rookPosition) ? 1 : 0) +
                (canCapturePawnInEast(board, rookPosition) ? 1 : 0);
    }

    private Position getPosition(char[][] board, char piece) {
        for (int row = 0 ; row < board.length ; row++) {
            for (int column = 0 ; column < board[0].length ; column++) {
                if (board[row][column] == piece) return new Position(row, column);
            }
        }
        return null;
    }

    private boolean canCapturePawnInNorth(char[][] board, Position rookPosition) {
        for (int row = rookPosition.row - 1 ; row >= 0 ; row--) {
            if (board[row][rookPosition.column] == BISHOP) return false;
            if (board[row][rookPosition.column] == PAWN) return true;
        }
        return false;
    }

    private boolean canCapturePawnInSouth(char[][] board, Position rookPosition) {
        for (int row = rookPosition.row + 1 ; row < board.length ; row++) {
            if (board[row][rookPosition.column] == BISHOP) return false;
            if (board[row][rookPosition.column] == PAWN) return true;
        }
        return false;
    }

    private boolean canCapturePawnInWest(char[][] board, Position rookPosition) {
        for (int column = rookPosition.column + 1 ; column < board[0].length ; column++) {
            if (board[rookPosition.row][column] == BISHOP) return false;
            if (board[rookPosition.row][column] == PAWN) return true;
        }
        return false;
    }

    private boolean canCapturePawnInEast(char[][] board, Position rookPosition) {
        for (int column = rookPosition.column - 1 ; column >= 0 ; column--) {
            if (board[rookPosition.row][column] == BISHOP) return false;
            if (board[rookPosition.row][column] == PAWN) return true;
        }
        return false;
    }
}
