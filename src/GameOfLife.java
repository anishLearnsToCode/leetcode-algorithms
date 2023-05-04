// https://leetcode.com/problems/game-of-life

import java.util.Arrays;

public class GameOfLife {
    private static int rows, columns;

    public static void gameOfLife(int[][] board) {
        rows = board.length;
        columns = board[0].length;
        final int[][] adjacentLiveSquares = getAdjacentLiveSquares(board);
        System.out.println(Arrays.deepToString(adjacentLiveSquares));

        for (int row = 0 ; row < rows ; row++) {
            for (int column = 0 ; column < columns ; column++) {
                if (board[row][column] == 1) {
                    if (adjacentLiveSquares[row][column] < 2 || adjacentLiveSquares[row][column] > 3) {
                        board[row][column] = 0;
                    }
                } else {
                    if (adjacentLiveSquares[row][column] == 3) {
                        board[row][column] = 1;
                    }
                }
            }
        }
    }

    private static int[][] getAdjacentLiveSquares(int[][] board) {
        final int[][] result = new int[rows][columns];

        for (int row = 0 ; row < rows ; row++) {
            for (int column = 0 ; column < columns ; column++) {
                result[row][column] = (row > 0 ? getRowSum(board, row - 1, column) : 0)
                        + (row + 1 < rows ? getRowSum(board, row + 1, column) : 0)
                        + (column > 0 ? board[row][column - 1] : 0)
                        + (column + 1 < columns ? board[row][column + 1] : 0);
            }
        }

        return result;
    }

    private static int getRowSum(int[][] board, int row, int column) {
        return board[row][column]
                + (column - 1 >= 0 ? board[row][column - 1] : 0)
                + (column + 1 < columns ? board[row][column + 1] : 0);
    }

    public static void main(String[] args) {
        int[][] result = new int[][] {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(result);
        System.out.println(Arrays.deepToString(result));
    }
}
