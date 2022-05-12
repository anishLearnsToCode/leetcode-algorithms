// https://leetcode.com/problems/contains-duplicate
// T: O(N)
// S: O(N)

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] array) {
        Set<Integer> elements = new HashSet<>();
        for (int element : array) {
            if (elements.contains(element)) {
                return true;
            }
            elements.add(element);
        }
        return false;
    }
}
