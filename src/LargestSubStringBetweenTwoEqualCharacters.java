import java.util.HashMap;
import java.util.Map;

public class LargestSubStringBetweenTwoEqualCharacters {
    public int maxLengthBetweenEqualCharacters(String s) {
        int maxLength = -1;
        final Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++) {
            if (lastIndex.containsKey(s.charAt(i))) {
                maxLength = Math.max(maxLength, i - lastIndex.get(s.charAt(i)) - 1);
            } else {
                lastIndex.put(s.charAt(i), i);
            }
        }
        return maxLength;
    }
}
