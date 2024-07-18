// https://leetcode.com/problems/find-the-xor-of-numbers-which-appear-twice
// T: O(N)
// S: O(N)

import java.util.HashSet;
import java.util.Set;

public class FindTheXOROfNumbersWhichAppearTwice {
    public int duplicateNumbersXOR(int[] array) {
        final Set<Integer> numbers = new HashSet<>();
        int result = 0;
        for (int element : array) {
            if (numbers.contains(element)) {
                result ^= element;
            }
            numbers.add(element);
        }
        return result;
    }
}
