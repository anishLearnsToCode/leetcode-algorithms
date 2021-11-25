import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {
    private final String[] morseCodeMapping = new String[] {
            ".-","-...","-.-.","-..",".","..-.",
            "--.","....","..",".---","-.-",".-..",
            "--","-.","---",".--.","--.-",".-.",
            "...","-","..-","...-",".--","-..-",
            "-.--","--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> transformations = new HashSet<>();
        for (String word : words) {
            transformations.add(morseValue(word));
        }
        return transformations.size();
    }

    private String morseValue(String word) {
        StringBuilder result = new StringBuilder();
        for (char character : word.toCharArray()) {
            result.append(morseValue(character));
        }
        return result.toString();
    }

    private String morseValue(char character) {
        return morseCodeMapping[character - 'a'];
    }
}
