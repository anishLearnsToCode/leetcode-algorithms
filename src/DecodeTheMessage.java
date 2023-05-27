// https://leetcode.com/problems/decode-the-message
// T: O(|key| + |message|)
// S: O(1)

import java.util.HashMap;
import java.util.Map;

public class DecodeTheMessage {
    public String decodeMessage(String key, String message) {
        final Map<Character, Character> mapping = getSubstitutionMap(key);
        final StringBuilder result = new StringBuilder();
        System.out.println(mapping);

        for (int index = 0 ; index < message.length() ; index++) {
            if (message.charAt(index) == ' ') {
                result.append(' ');
            } else {
                result.append(mapping.get(message.charAt(index)));
            }
        }

        return result.toString();
    }

    private Map<Character, Character> getSubstitutionMap(String key) {
        final Map<Character, Character> result = new HashMap<>();
        char letter = 'a';
        for (int index = 0 ; index < key.length() ; index++) {
            if (!result.containsKey(key.charAt(index)) && key.charAt(index) != ' ') {
                result.put(key.charAt(index), letter++);
            }
        }
        return result;
    }
}
