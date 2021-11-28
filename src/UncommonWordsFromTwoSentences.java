import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String s1, String s2) {
        final Map<String, Integer> sentence1Words = getWordFrequencies(s1);
        final Map<String, Integer> sentence2Words = getWordFrequencies(s2);
        final List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sentence1Words.entrySet()) {
            if (entry.getValue() == 1 && !sentence2Words.containsKey(entry.getKey())) result.add(entry.getKey());
        }
        for (Map.Entry<String, Integer> entry : sentence2Words.entrySet()) {
            if (entry.getValue() == 1 && !sentence1Words.containsKey(entry.getKey())) result.add(entry.getKey());
        }
        return result.toArray(new String[] {});
    }

    private Map<String, Integer> getWordFrequencies(String string) {
        final Map<String, Integer> map = new HashMap<>();
        StringBuilder word =new StringBuilder();
        String s;
        for (int index = 0 ; index < string.length() ; index++) {
            if (string.charAt(index) == ' ') {
                s = word.toString();
                map.put(s, map.getOrDefault(s, 0) + 1);
                word = new StringBuilder();
            } else word.append(string.charAt(index));
        }
        s = word.toString();
        map.put(s, map.getOrDefault(s, 0) + 1);
        return map;
    }
}
