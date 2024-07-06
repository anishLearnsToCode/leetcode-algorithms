// https://leetcode.com/problems/minimum-number-game
// T: O(N*log(N))
// S: O(log(N))

import java.util.Arrays;

public class MinimumNumberGame {
    public int[] numberGame(int[] array) {
        Arrays.sort(array);
        final int[] result = new int[array.length];

        for (int i = 0 ; i < array.length ; i += 2) {
            result[i] = array[i + 1];
            result[i + 1] = array[i];
        }

        return result;
    }
}
