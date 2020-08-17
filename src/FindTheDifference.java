import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> frequenciesOrigin = getFrequencies(s);
        Map<Character, Integer> frequenciesNew = getFrequencies(t);
        return difference(frequenciesOrigin, frequenciesNew);
    }

    private Map<Character, Integer> getFrequencies(String string) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }
        return frequencies;
    }

    private char difference(Map<Character, Integer> frequencies2, Map<Character, Integer> frequencies1) {
        for (Character character : frequencies1.keySet()) {
            if (frequencies1.get(character) != frequencies2.getOrDefault(character, 0)) {
                return character;
            }
        }
        return '\0';
    }
}
