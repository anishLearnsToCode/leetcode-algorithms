import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        Map<Character, Integer> commonChars = getCharsFrequency(words[0]);
        Map<Character, Integer> wordChars;
        for (int i = 1 ; i < words.length ; i++) {
            wordChars = getCharsFrequency(words[i]);
            for (char letter : commonChars.keySet()) {
                commonChars.put(letter, Math.min(commonChars.get(letter), wordChars.getOrDefault(letter, 0)));
            }
        }
        return toList(commonChars);
    }

    private List<String> toList(Map<Character, Integer> characters) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : characters.entrySet()) {
            if (entry.getValue() > 0) {
                for (int i = 0 ; i < entry.getValue() ; i++) result.add(entry.getKey() + "");
            }
        }
        return result;
    }

    private Map<Character, Integer> getCharsFrequency(String string) {
        Map<Character, Integer> result = new HashMap<>();
        char character;
        for (int index = 0 ; index < string.length() ; index++) {
            character = string.charAt(index);
            result.put(character, result.getOrDefault(character, 0) + 1);
        }
        return result;
    }
}
