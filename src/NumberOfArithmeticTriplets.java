// https://leetcode.com/problems/number-of-arithmetic-triplets
// T: O(N)
// S: O(N)

import java.util.HashSet;
import java.util.Set;

public class NumberOfArithmeticTriplets {
    public int arithmeticTriplets(int[] array, int diff) {
        final Set<Integer> elements = new HashSet<>();
        int triplets = 0;

        for (int number : array) {
            if (elements.contains(number - diff) && elements.contains(number - 2 * diff)) {
                triplets++;
            }
            elements.add(number);
        }

        return triplets;
    }
}
