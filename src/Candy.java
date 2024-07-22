// https://leetcode.com/problems/candy
// T: O(N)
// S: O(N)

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        final int[] candies = new int[ratings.length];

        // left pass
        for (int i = 1 ; i < ratings.length ; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // right pass
        for (int i = ratings.length - 2 ; i >= 0 ; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        return Arrays.stream(candies).sum() + ratings.length;
    }
}
