import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        String text = paragraph.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        Set<String> bannedWords =  new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> wordFrequencies = new HashMap<>();

        for (String word :  text.split("\\s+")) {
            if (!bannedWords.contains(word)) {
                wordFrequencies.put(word, wordFrequencies.getOrDefault(word, 0) + 1);
            }
        }

        return Collections.max(wordFrequencies.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
