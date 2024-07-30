// https://leetcode.com/problems/n-queens-ii
// T: O(N!)
// S: O(N^2)

import java.util.ArrayList;
import java.util.List;

public class NQueensII {
    private static boolean[] rows, columns;
    private static int result = 0;

    public int totalNQueens(int n) {
        result = 0;
        final List<String> board = getEmptyBoard(n);
        rows = new boolean[n];
        columns = new boolean[n];
        nQueens(0, n, board, 0);
        return result;
    }

    private static void nQueens(int row, int n, List<String> board, int queens) {
        if (row == n) {
            if (queens == n) {
                result++;
            }
            return;
        }

        for (int column = 0 ; column < n ; column++) {
            if (canPlace(board, row, column)) {
                placeQueen(board, row, column);
                nQueens(row + 1, n, board, queens + 1);
                removeQueen(board, row, column);
            }
        }
    }

    private static void placeQueen(List<String> board, int row, int column) {
        board.set(
                row,
                board.get(row).substring(0, column) + 'Q' + board.get(row).substring(column + 1)
        );
        rows[row] = true;
        columns[column] = true;
    }

    private static void removeQueen(List<String> board, int row, int column) {
        board.set(
                row,
                board.get(row).substring(0, column) + '.' + board.get(row).substring(column + 1)
        );
        rows[row] = false;
        columns[column] = false;
    }

    private static boolean canPlace(List<String> board, int row, int column) {
        return !rows[row] && !columns[column] && !queenInLeftDiagonal(board, row, column)
                && !queenInRightDiagonal(board, row, column);
    }

    private static boolean queenInLeftDiagonal(List<String> board, int row, int column) {
        for (int i = row - 1, j = column - 1 ; i >= 0 && j >= 0 ; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return true;
            }
        }
        for (int i = row + 1, j = column + 1 ; i < board.size() && j < board.size() ; i++, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return true;
            }
        }
        return false;
    }

    private static boolean queenInRightDiagonal(List<String> board, int row, int column) {
        for (int i = row - 1, j = column + 1 ; i >= 0 && j < board.size() ; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return true;
            }
        }
        for (int i = row + 1, j = column - 1 ; i < board.size() && j >= 0 ; i++, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return true;
            }
        }
        return false;
    }

    private static List<String> getEmptyBoard(int n) {
        final List<String> board = new ArrayList<>();
        final String line = ".".repeat(n);
        for (int i = 0 ; i < n ; i++) {
            board.add(line);
        }
        return board;
    }
}
