// https://leetcode.com/problems/group-anagrams
// T: O(|words| * |words[i]|)
// S: O(|words| * |words[i]|)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] words) {
        final Map<String, List<String>> anagrams = new HashMap<>();
        for (String word : words) {
            final String signature = getSignature(word);
            if (anagrams.containsKey(signature)) {
                anagrams.get(signature).add(word);
            } else {
                List<String> list = new ArrayList<>();
                list.add(word);
                anagrams.put(signature, list);
            }
        }
        return new ArrayList<>(anagrams.values());
    }

    private String getSignature(String string) {
        final char[] array = new char[26];
        for (int i = 0 ; i < string.length() ; i++) {
            array[string.charAt(i) - 'a']++;
        }
        return String.valueOf(array);
    }
}
