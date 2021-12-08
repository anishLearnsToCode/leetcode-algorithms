import java.util.HashMap;
import java.util.Map;

public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        final Map<Character, Integer> characterFrequencies = getCharFrequencies(chars);
        int result = 0;
        for (String word : words) {
            if (word.length() > chars.length()) continue;
            Map<Character, Integer> wordCharFrequencies = getCharFrequencies(word);
            if (canBeFormedBy(wordCharFrequencies, characterFrequencies)) {
                result += word.length();
            }
        }
        return result;
    }

    private Map<Character, Integer> getCharFrequencies(String string) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            frequencies.put(string.charAt(index), frequencies.getOrDefault(string.charAt(index), 0) + 1);
        }
        return frequencies;
    }

    private boolean canBeFormedBy(Map<Character, Integer> frequencies1, Map<Character, Integer> frequencies2) {
        for (Map.Entry<Character, Integer> entry : frequencies1.entrySet()) {
            if (frequencies2.getOrDefault(entry.getKey(), 0) < entry.getValue()) return false;
        }
        return true;
    }
}
