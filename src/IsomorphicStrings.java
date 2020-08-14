import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
    public static boolean isIsomorphic(String s, String t) {
        Set<Character> mappingsTo = new HashSet<>();
        Map<Character, Character> mappings = new HashMap<>();

        for (int index = 0 ; index < s.length() ; index++) {
            char a = s.charAt(index);
            char b = t.charAt(index);
            if (mappings.getOrDefault(a, b) != b || (!mappings.containsKey(a) && mappingsTo.contains(b))) {
                return false;
            }
            mappings.put(a, b);
            mappingsTo.add(b);
        }

        return true;
    }
}
