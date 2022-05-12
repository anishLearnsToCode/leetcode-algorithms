// https://leetcode.com/problems/valid-anagram
// T: O(|s| + |t|)
// S: O(1)


import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> frequency1 = getFrequencies(s);
        Map<Character, Integer> frequency2 = getFrequencies(t);
        return frequency1.equals(frequency2);
    }

    private static Map<Character, Integer> getFrequencies(String string) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            frequency.put(string.charAt(index), frequency.getOrDefault(string.charAt(index), 0) + 1);
        }
        return frequency;
    }
}
