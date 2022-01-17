// https://leetcode.com/problems/word-search
// T: O(4^{m * n})
// S: O(m * n)

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        final int rows = board.length, columns = board[0].length;

        for (int row = 0; row < rows ; row++) {
            for (int column = 0; column < columns ; column++) {
                if (exist(board, row, column, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean exist(char[][] board, int row, int column, String word, int i) {
        if (i == word.length()) return true;
        if (row < 0 || column < 0 || row == board.length || column == board[row].length) return false;
        if (board[row][column] != word.charAt(i)) return false;

        board[row][column] ^= 256;
        boolean exist = exist(board, row, column+1, word, i + 1)
                || exist(board, row, column - 1, word, i + 1)
                || exist(board, row + 1, column, word, i + 1)
                || exist(board, row - 1, column, word, i + 1);

        board[row][column] ^= 256;
        return exist;
    }
}
