// https://leetcode.com/problems/valid-sudoku
// T: O(1)
// S: O(1)

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    private static final int SUDOKU_SIZE = 9;

    public boolean isValidSudoku(char[][] board) {
        if (repetitionInRows(board)) return false;
        if (repetitionInColumns(board)) return false;
        return !repetitionInBlocks(board);
    }

    private boolean repetitionInRows(char[][] board) {
        for (char[] row : board) {
            if (repetitionInRow(row)) return true;
        }
        return false;
    }

    private boolean repetitionInRow(char[] row) {
        final Set<Character> digits = new HashSet<>();
        for (char character : row) {
            if (Character.isDigit(character)) {
                if (digits.contains(character)) return true;
                digits.add(character);
            }
        }
        return false;
    }

    private boolean repetitionInColumns(char[][] board) {
        final Set<Character> digits = new HashSet<>();
        for (int column = 0 ; column < SUDOKU_SIZE ; column++) {
            digits.clear();
            for (int row = 0 ; row < SUDOKU_SIZE ; row++) {
                char c = board[row][column];
                if (Character.isDigit(c)) {
                    if (digits.contains(c)) return true;
                    digits.add(c);
                }
            }
        }
        return false;
    }

    private boolean repetitionInBlocks(char[][] board) {
        for (int i = 0 ; i < SUDOKU_SIZE / 3 ; i++) {
            for (int j = 0 ; j < SUDOKU_SIZE / 3 ; j++) {
                if (repetitionInBlock(board, i, j)) return true;
            }
        }
        return false;
    }

    private boolean repetitionInBlock(final char[][] board, final int i, final int j) {
        final Set<Character> digits = new HashSet<>();
        for (int row = 3 * i ; row < 3 * i + 3 ; row++) {
            for (int column = 3 * j ; column < 3 * j + 3 ; column++) {
                char c = board[row][column];
                if (Character.isDigit(c)) {
                    if (digits.contains(c)) return true;
                    digits.add(c);
                }
            }
        }
        return false;
    }
}
