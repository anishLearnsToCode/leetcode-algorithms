// https://leetcode.com/problems/min-max-game
// T: O(N)
// S: O(1)

public class MinMaxGame {
    public int minMaxGame(int[] array) {
        for (int len = array.length / 2 ; len > 1 ; len /= 2) {
            for (int i = 0 ; i < len ; i++) {
                array[i] = i % 2 == 0 ? Math.min(array[2 * i], array[2 * i + 1]) : Math.max(array[2 * i], array[2 * i + 1]);
            }
        }
        return array[0];
    }
}
