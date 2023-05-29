// https://leetcode.com/problems/check-distances-between-same-letters
// T: O(N)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class CheckDistancesBetweenSameLetters {
    public boolean checkDistances(String s, int[] distances) {
        final Map<Character, Integer> firstOccurrenceIndex = new HashMap<>();
        for (int index = 0 ; index < s.length() ; index++) {
            char letter = s.charAt(index);
            if (firstOccurrenceIndex.containsKey(letter)) {
                int distance = index - firstOccurrenceIndex.get(letter) - 1;
                if (distance != distances[letter - 'a']) {
                    return false;
                }
            } else firstOccurrenceIndex.put(letter, index);
        }
        return true;
    }
}
