// https://leetcode.com/problems/minimum-amount-of-time-to-fill-cups
// T: O(1)
// S: O(1)

import java.util.Arrays;

public class MinimumAmountOfTimeToFillCups {
    public int fillCups(int[] amount) {
        return Math.max(
                Arrays.stream(amount).max().getAsInt(),
                (Arrays.stream(amount).sum() + 1) / 2
        );
    }
}
