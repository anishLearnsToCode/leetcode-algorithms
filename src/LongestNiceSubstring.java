import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
    public String longestNiceSubstring(String s) {
        String longestNiceSubString = "";
        Set<Character> alphabets = new HashSet<>();
        for (int i = 0 ; i < s.length() ; i++) {
            for (int j = i ; j < s.length() ; j++) {
                alphabets.add(s.charAt(j));
                if (containsBotLowerAndUpperCase(alphabets) && j - i + 1 > longestNiceSubString.length()) {
                    longestNiceSubString = s.substring(i, j + 1);
                }
            }
            alphabets.clear();
        }
        return longestNiceSubString;
    }

    private boolean containsBotLowerAndUpperCase(Set<Character> alphabets) {
        for (char alphabet : alphabets) {
            if (!alphabets.contains(inverse(alphabet))) {
                return false;
            }
        }
        return true;
    }

    private char inverse(char c) {
        return Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
    }

    private Set<Character> getCharacters(String s, int start, int end) {
        final Set<Character> set = new HashSet<>();
        for (int index = start ; index <= end ; index++) {
            set.add(s.charAt(index));
        }
        return set;
    }
}
