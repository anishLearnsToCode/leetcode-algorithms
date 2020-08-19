import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public int longestPalindrome(String string) {
        Map<Character, Integer> frequencies = getFrequencies(string);
        int length = 0;
        boolean encounteredOdd = false;
        for (int frequency : frequencies.values()) {
            if (frequency % 2 == 0) {
                length += frequency;
            } else {
                length += (frequency / 2) * 2;
                encounteredOdd = true;
            }
        }
        return length + (encounteredOdd ? 1 : 0);
    }

    private Map<Character, Integer> getFrequencies(String string) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
        }
        return frequencies;
    }
}
