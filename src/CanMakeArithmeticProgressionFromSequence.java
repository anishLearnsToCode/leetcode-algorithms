// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/
// T: O(n)
// S: O(n)

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CanMakeArithmeticProgressionFromSequence {
    public boolean canMakeArithmeticProgression(int[] array) {
        final int a = Arrays.stream(array).min().getAsInt();
        final int l = Arrays.stream(array).max().getAsInt();
        if (a == l) return true;
        if ((l - a) % (array.length - 1) != 0) return false;
        final int d = (l - a) / (array.length - 1);
        Set<Integer> elements = new HashSet<>();
        for (int number : array) {
            if (elements.contains(number)) return false;
            if ((number - a) % d != 0)return false;
            elements.add(number);
        }
        return true;
    }
}
