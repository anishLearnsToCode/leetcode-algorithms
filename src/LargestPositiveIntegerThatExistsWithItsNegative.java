// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative
// T: O(N)
// S: O(N)

import java.util.HashSet;
import java.util.Set;

public class LargestPositiveIntegerThatExistsWithItsNegative {
    public int findMaxK(int[] array) {
        int largest = -1;
        final Set<Integer> numbers = new HashSet<>();

        for (int element : array) {
            if (Math.abs(element) > largest && numbers.contains(-element)) {
                largest = Math.abs(element);
            }
            numbers.add(element);
        }

        return largest;
    }
}
