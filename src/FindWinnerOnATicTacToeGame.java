public class FindWinnerOnATicTacToeGame {
    public String tictactoe(int[][] moves) {
        String winner = getWinnerInTicTacToe(moves);
        if ("".equals(winner)) return moves.length == 9 ? "Draw" : "Pending";
        return winner;
    }

    private String getWinnerInTicTacToe(int[][] moves) {
        final int[] rows = new int[3], columns = new int[3];
        int d1 = 0, d2 = 0, k = 1;
        for (int[] move : moves) {
            rows[move[0]] += k;
            columns[move[1]] += k;
            if (move[0] == move[1]) d1 += k;
            if (move[0] == 2 - move[1]) d2 += k;
            k *= -1;
        }
        String result = winnerCheckInArray(rows);
        if (!"".equals(result)) return result;
        result = winnerCheckInArray(columns);
        if (!"".equals(result)) return result;
        if (d1 == 3 || d2 == 3) return "A";
        if (d1 == -3 || d2 == -3) return "B";
        return "";
    }

    private String winnerCheckInArray(int[] array) {
        for (int element : array) {
            if (element == 3) return "A";
            if (element == -3) return "B";
        }
        return "";
    }
}
