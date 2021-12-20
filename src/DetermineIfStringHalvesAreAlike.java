import java.util.Set;

public class DetermineIfStringHalvesAreAlike {
    private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public boolean halvesAreAlike(String s) {
        return numberOfVowels(s, 0, s.length() / 2) == numberOfVowels(s, s.length() / 2);
    }

    private int numberOfVowels(String s, int startIndex) {
        return numberOfVowels(s, startIndex, s.length());
    }

    private int numberOfVowels(String s, int startIndex, int endIndex) {
        int count = 0;
        for (int index = startIndex ; index < endIndex ; index++) {
            if (VOWELS.contains(s.charAt(index))) {
                count++;
            }
        }
        return count;
    }
}
