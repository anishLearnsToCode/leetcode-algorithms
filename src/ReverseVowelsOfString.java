import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ReverseVowelsOfString {
    private static final Set<Character> VOWELS = new HashSet<>();

    static {
        VOWELS.add('a');
        VOWELS.add('e');
        VOWELS.add('i');
        VOWELS.add('o');
        VOWELS.add('u');
        VOWELS.add('A');
        VOWELS.add('E');
        VOWELS.add('I');
        VOWELS.add('O');
        VOWELS.add('U');
    }

    public static String reverseVowels(String string) {
        List<Character> vowels = getVowels(string);
        StringBuilder result = new StringBuilder();
        for (int index = 0, j = vowels.size() - 1 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            result.append((char) (isVowel(character) ? vowels.get(j--) : character));
        }
        return result.toString();
    }

    private static boolean isVowel(char character) {
        return VOWELS.contains(character);
    }

    private static List<Character> getVowels(String string) {
        List<Character> vowels = new ArrayList<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char character = string.charAt(index);
            if (isVowel(character)) {
                vowels.add(character);
            }
        }
        return vowels;
    }
}
