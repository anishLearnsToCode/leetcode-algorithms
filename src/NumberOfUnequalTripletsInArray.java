// https://leetcode.com/problems/number-of-unequal-triplets-in-array
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class NumberOfUnequalTripletsInArray {
    public int unequalTriplets(int[] array) {
        final Map<Integer, Integer> frequency = new HashMap<>();
        int pairs = 0, triplets = 0;
        for (int index = 0 ; index < array.length ; index++) {
            frequency.put(array[index], frequency.getOrDefault(array[index], 0) + 1);
            final int pairsWithElement =  index + 1 - frequency.getOrDefault(array[index], 0);
            pairs += pairsWithElement;
            final int pairsWithoutElement = pairs - pairsWithElement * frequency.getOrDefault(array[index], 0);
            triplets += pairsWithoutElement;
        }
        return triplets;
    }
}
