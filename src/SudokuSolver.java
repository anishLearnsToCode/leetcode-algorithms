// https://leetcode.com/problems/sudoku-solver
// T: O(n^2 * k) but n = 9 and k = 9 so just O(1)
// S: O(n^2) but n = 9 so just O(1)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SudokuSolver {
    private record Position(int row, int column) {
        private static final Position start = new Position(0, 0);

        private boolean isValid() {
            return row >= 0
                    && row < 9
                    && column >= 0
                    && column < 9;
        }

        private Position next() {
            if (column == 8) return new Position(row + 1, 0);
            return new Position(row, column + 1);
        }
    }

    private static final Map<Integer, Set<Integer>> rows = new HashMap<>();
    private static final Map<Integer, Set<Integer>> columns = new HashMap<>();
    private static final Map<Integer, Set<Integer>> subGrids = new HashMap<>();

    public static void solveSudoku(char[][] board) {
        computeDigitsInRows(board);
        computeDigitsInColumns(board);
        computeDigitsInSubGrids(board);
        solveSudoku(board, Position.start);
    }

    private static boolean solveSudoku(char[][] board, Position position) {
        if (!position.isValid()) return true;
        if (isAlreadyFilled(board, position)) return solveSudoku(board, position.next());

        for (int i = 1 ; i <= 9 ; i++) {
            if (isInRow(i, position) || isInColumn(i, position) || isInSubGrid(i, position)) continue;
            insertInGrid(i, position, board);
            boolean solved = solveSudoku(board, position.next());
            if (solved) return true;
            removeFromGrid(i, position, board);
        }
        return false;
    }

    private static boolean isAlreadyFilled(char[][] board, Position position) {
        return board[position.row][position.column] != '.';
    }

    private static boolean isInRow(int digit, Position position) {
        return rows.get(position.row).contains(digit);
    }

    private static boolean isInColumn(int digit, Position position) {
        return columns.get(position.column).contains(digit);
    }

    private static boolean isInSubGrid(int digit, Position position) {
        return subGrids.get(getSubGridId(position)).contains(digit);
    }

    private static void insertInGrid(int digit, Position position, char[][] board) {
        rows.get(position.row).add(digit);
        columns.get(position.column).add(digit);
        subGrids.get(getSubGridId(position)).add(digit);
        board[position.row][position.column] = toChar(digit);
    }

    private static void removeFromGrid(int digit, Position position, char[][] board) {
        rows.get(position.row).remove(digit);
        columns.get(position.column).remove(digit);
        subGrids.get(getSubGridId(position)).remove(digit);
        board[position.row][position.column] = '.';
    }

    private static void computeDigitsInRows(char[][] board) {
        for (int row = 0 ; row < 9 ; row++) {
            final Set<Integer> digits = new HashSet<>();
            for (char element : board[row]) {
                if (Character.isDigit(element)) {
                    digits.add(toInt(element));
                }
            }
            rows.put(row, digits);
        }
    }

    private static void computeDigitsInColumns(char[][] board) {
        for (int column = 0 ; column < 9 ; column++) {
            final Set<Integer> digits = new HashSet<>();
            for (int row = 0 ; row < 9 ; row++) {
                if (Character.isDigit(board[row][column])) {
                    digits.add(toInt(board[row][column]));
                }
            }
            columns.put(column, digits);
        }
    }

    private static void computeDigitsInSubGrids(char[][] board) {
        for (int i = 0 ; i < 3 ; i++) {
            for (int j = 0 ; j < 3 ; j++) {
                final int subGridId = getSubGridId(i, j);
                final Set<Integer> digits = new HashSet<>();
                for (int row = 3 * i ; row < 3 * i + 3 ; row++) {
                    for (int column = 3 * j ; column < 3 * j + 3 ; column++) {
                        if (Character.isDigit(board[row][column])) {
                            digits.add(toInt(board[row][column]));
                        }
                    }
                }
                subGrids.put(subGridId, digits);
            }
        }
    }

    private static int toInt(char c) {
        return c - '0';
    }

    private static char toChar(int digit) {
        return (char) ('0' + digit);
    }

    private static int getSubGridId(int i, int j) {
        return 10 * i + j;
    }

    private static int getSubGridId(Position position) {
        int i = position.row / 3;
        int j = position.column / 3;
        return getSubGridId(i, j);
    }
}
