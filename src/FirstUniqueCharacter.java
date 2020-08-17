import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstUniqueCharacter {
    public int firstUniqChar(String string) {
        Map<Character, Integer> frequencies = getFrequencies(string);
        Set<Character> uniqueLetters = uniqueLetters(frequencies);
        for (int index = 0 ; index < string.length() ; index++) {
            if (uniqueLetters.contains(string.charAt(index))) {
                return index;
            }
        }
        return -1;
    }

    private Map<Character, Integer> getFrequencies(String string) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }
        return frequencies;
    }

    private Set<Character> uniqueLetters(Map<Character, Integer> frequencies) {
        Set<Character> letters = new HashSet<>();
        for (Map.Entry<Character, Integer> entry : frequencies.entrySet()) {
            char character = entry.getKey();
            int frequency = entry.getValue();
            if (frequency == 1) {
                letters.add(character);
            }
        }
        return letters;
    }
}
