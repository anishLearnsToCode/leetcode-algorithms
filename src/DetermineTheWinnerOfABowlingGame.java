// https://leetcode.com/problems/determine-the-winner-of-a-bowling-game
// T: O(n)
// S: O(1)

public class DetermineTheWinnerOfABowlingGame {
    public int isWinner(int[] player1, int[] player2) {
        final int score1 = getPlayerScore(player1);
        final int score2 = getPlayerScore(player2);
        if (score1 > score2) return 1;
        if (score1 < score2) return 2;
        return 0;
    }

    private int getPlayerScore(int[] scores) {
        int total = 0, seen10 = 0;
        for (int score : scores) {
            if (seen10 > 0) {
                total += 2 * score;
                seen10--;
            } else {
                total += score;
            }
            if (score == 10) {
                seen10 = 2;
            }
        }
        return total;
    }
}
