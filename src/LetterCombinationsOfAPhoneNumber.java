import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LetterCombinationsOfAPhoneNumber {
    private static final Map<Character, Set<Character>> NUMBER_TO_CHARS = Map.ofEntries(
            Map.entry('2', Set.of('a', 'b', 'c')),
            Map.entry('3', Set.of('d', 'e', 'f')),
            Map.entry('4', Set.of('g', 'h', 'i')),
            Map.entry('5', Set.of('j', 'k', 'l')),
            Map.entry('6', Set.of('m', 'n', 'o')),
            Map.entry('7', Set.of('p', 'q', 'r', 's')),
            Map.entry('8', Set.of('t', 'u', 'v')),
            Map.entry('9', Set.of('w', 'x', 'y', 'z'))
    );

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return Collections.emptyList();
        final List<String> result = new ArrayList<>();
        addLetterCombinationsToResult(digits, 0, "", result);
        return result;
    }

    private void addLetterCombinationsToResult(String s, int i, String current, List<String> result) {
        if (i == s.length()) {
            result.add(current);
            return;
        }
        for (char character : NUMBER_TO_CHARS.get(s.charAt(i))) {
            addLetterCombinationsToResult(s, i + 1, current + character, result);
        }
    }
}
