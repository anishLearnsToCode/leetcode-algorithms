// https://leetcode.com/problems/find-missing-and-repeated-values
// T: O(N*N)
// S: O(N*N)

import java.util.HashSet;
import java.util.Set;

public class FindMissingAndRepeatedValues {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        final int rows = grid.length, elements = rows * rows;
        int expectedSum = (elements * (elements + 1)) / 2, actualSum = 0;
        final Set<Integer> numbers = new HashSet<>();
        int repeatingElement = 0;

        for (int[] row : grid) {
            for (int element : row) {
                if (numbers.contains(element)) {
                    repeatingElement = element;
                }
                numbers.add(element);
                actualSum += element;
            }
        }

        int missingElement = expectedSum - actualSum + repeatingElement;

        return new int[] { repeatingElement, missingElement };
    }
}
