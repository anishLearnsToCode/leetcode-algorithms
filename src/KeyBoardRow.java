import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyBoardRow {
    private static final Map<Character, Integer> alphabetPosition = new HashMap<>();

    static {
        alphabetPosition.put('Q', 1);
        alphabetPosition.put('W', 1);
        alphabetPosition.put('E', 1);
        alphabetPosition.put('R', 1);
        alphabetPosition.put('T', 1);
        alphabetPosition.put('Y', 1);
        alphabetPosition.put('U', 1);
        alphabetPosition.put('I', 1);
        alphabetPosition.put('O', 1);
        alphabetPosition.put('P', 1);

        alphabetPosition.put('A', 2);
        alphabetPosition.put('S', 2);
        alphabetPosition.put('D', 2);
        alphabetPosition.put('F', 2);
        alphabetPosition.put('G', 2);
        alphabetPosition.put('H', 2);
        alphabetPosition.put('J', 2);
        alphabetPosition.put('K', 2);
        alphabetPosition.put('L', 2);

        alphabetPosition.put('Z', 3);
        alphabetPosition.put('X', 3);
        alphabetPosition.put('C', 3);
        alphabetPosition.put('V', 3);
        alphabetPosition.put('B', 3);
        alphabetPosition.put('N', 3);
        alphabetPosition.put('M', 3);
    }

    public static String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (singleRowWord(word.toUpperCase())) {
                result.add(word);
            }
        }

        return arrayListToArray(result);
    }

    private static String[] arrayListToArray(List<String> list) {
        String[] result = new String[list.size()];
        for (int index = 0 ; index < result.length ; index++) {
            result[index] = list.get(index);
        }
        return result;
    }

    private static boolean singleRowWord(String word) {
        int row = alphabetPosition.get(word.charAt(0));
        for (int index = 1 ; index < word.length() ; index++) {
            if (row != alphabetPosition.get(word.charAt(index))) {
                return false;
            }
        }
        return true;
    }
}
