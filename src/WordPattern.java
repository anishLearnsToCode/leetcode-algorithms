import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {
    public static boolean wordPattern(String pattern, String string) {
        Map<Character, String> bijection = new HashMap<>();
        Set<String> wordsMappedTo = new HashSet<>();
        String[] words = string.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }

        for (int index = 0 ; index < pattern.length() ; index++) {
            char letter = pattern.charAt(index);
            String word = words[index];

            if (!bijection.getOrDefault(letter, word).equals(word) ||
                    (!bijection.containsKey(letter) && wordsMappedTo.contains(word))) {
                return false;
            }

            bijection.put(letter, word);
            wordsMappedTo.add(word);
        }

        return true;
    }
}
