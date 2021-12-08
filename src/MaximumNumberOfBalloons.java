import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MaximumNumberOfBalloons {
    private static final Set<Character> BALLOON_CHARACTERS = Set.of('b', 'a', 'l', 'o', 'n');
    private static final Set<Character> BALLOON_DOUBLE_LETTERS = Set.of('l', 'o');

    public int maxNumberOfBalloons(String text) {
        Map<Character, Integer> frequencies = getCharacterFrequencies(text);
        int result = Integer.MAX_VALUE;
        for (char character : BALLOON_CHARACTERS) {
            result = Math.min(result, frequencies.getOrDefault(character, 0));
        }
        return result;
    }

    private Map<Character, Integer> getCharacterFrequencies(String string) {
        final Map<Character, Integer> frequencies = new HashMap<>();
        char character;
        for (int i = 0 ; i < string.length() ; i++) {
            character = string.charAt(i);
            if (BALLOON_CHARACTERS.contains(character)) {
                frequencies.put(character, frequencies.getOrDefault(character, 0) + 1);
            }
        }
        for (char letter : BALLOON_DOUBLE_LETTERS) {
            frequencies.put(letter, frequencies.getOrDefault(letter, 0) / 2);
        }
        return frequencies;
    }
}
