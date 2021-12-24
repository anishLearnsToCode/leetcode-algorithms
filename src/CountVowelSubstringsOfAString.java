// https://leetcode.com/problems/count-vowel-substrings-of-a-string
// T: O(|word|)
// S: O(|word|)

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountVowelSubstringsOfAString {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o','u');

    public static int countVowelSubstrings(String word) {
        int vowelSubstrings = 0;
        final Map<Character, Integer> vowels = new HashMap<>();
        for (int j = 0 ; j < word.length() ; j++) {
            if (isVowel(word.charAt(j))) {
                addToMap(vowels, word.charAt(j));
                for (int i = j + 1, k = j ; i < word.length() ; i++) {
                    if (isVowel(word.charAt(i))) {
                        addToMap(vowels, word.charAt(i));
                        for ( ; k < i && vowels.size() == 5 ; k++) {
                            removeFromMap(vowels, word.charAt(k));
                        }
                        vowelSubstrings += k - j;
                        if (i == word.length() - 1) {
                            j = i;
                        }
                    } else {
                        j = i;
                        vowels.clear();
                        break;
                    }
                }
            }
        }
        return vowelSubstrings;
    }

    private static boolean isVowel(char c) {
        return VOWELS.contains(c);
    }

    private static void addToMap(Map<Character, Integer> frequencies, char c) {
        frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
    }

    private static void removeFromMap(Map<Character, Integer> frequencies, char c) {
        if (frequencies.getOrDefault(c, 0) == 1) frequencies.remove(c);
        else frequencies.put(c, frequencies.get(c) - 1);
    }
}
