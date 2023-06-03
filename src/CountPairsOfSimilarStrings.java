// https://leetcode.com/problems/count-pairs-of-similar-strings
// T: O(|words| * |words[i]|)
// S: O(|words|)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountPairsOfSimilarStrings {
    public int similarPairs(String[] words) {
        Map<Set<Character>, Integer> frequency = new HashMap<>();
        int pairs = 0;
        for (String word : words) {
            final Set<Character> letters = getLetters(word);
            pairs += frequency.getOrDefault(letters, 0);
            frequency.put(letters, frequency.getOrDefault(letters, 0) + 1);
        }
        return pairs;
    }

    private Set<Character> getLetters(String word) {
        final Set<Character> set = new HashSet<>();
        for (int index = 0 ; index < word.length() ; index++) {
            set.add(word.charAt(index));
        }
        return set;
    }
}
