// https://leetcode.com/problems/find-the-losers-of-the-circular-game
// T: O(N)
// S: O(N)

import java.util.HashSet;
import java.util.Set;

public class FindTheLosersOfTheCircularGame {
    public int[] circularGameLosers(int n, int k) {
        final Set<Integer> players = new HashSet<>();
        for (int i = 0, turn = 1 ;  ; i = (i + turn * k) % n, turn++) {
            if (players.contains(i)) {
                break;
            }
            players.add(i);
        }
        final int totalLosers = n - players.size();
        final int[] losers = new int[totalLosers];
        for (int i = 1, j = 0 ; i <= n ; i++) {
            if (!players.contains(i - 1)) {
                losers[j++] = i;
            }
        }
        return losers;
    }
}
