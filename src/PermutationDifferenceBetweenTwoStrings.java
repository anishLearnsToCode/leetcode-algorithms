// https://leetcode.com/problems/permutation-difference-between-two-strings
// T: O(N)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class PermutationDifferenceBetweenTwoStrings {
    public int findPermutationDifference(String s, String t) {
        final Map<Character, Integer> letterIndexes = getCharacterIndexMapping(s);
        int sum = 0;

        for (int i = 0 ; i < t.length() ; i++) {
            sum += Math.abs(i - letterIndexes.get(t.charAt(i)));
        }

        return sum;
    }

    private static Map<Character, Integer> getCharacterIndexMapping(String s) {
        final Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++) {
            map.put(s.charAt(i), i);
        }
        return map;
    }
}
