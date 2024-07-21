// https://leetcode.com/problems/find-the-winning-player-in-coin-game
// T: O(1)
// S: O(1)

public class FindTheWinningPlayerInCoinGame {
    public String losingPlayer(int x, int y) {
        final int maxGames10CentCoins = y / 4;
        final int maxGamesPossible = Math.min(x, maxGames10CentCoins);
        return  maxGamesPossible % 2 == 0 ? "Bob" : "Alice";
    }
}
