import java.util.LinkedList;
import java.util.Queue;

public class DecryptStringFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        final StringBuilder result = new StringBuilder();
        final Queue<Character> queue = new LinkedList<>();
        for (int index = 0 ; index  < s.length() ; index++) {
            if (queue.size() == 2) {
                if (s.charAt(index) == '#') {
                    result.append(numberToChar(queue.poll(), queue.poll()));
                    continue;
                } else {
                    result.append(numberToChar(queue.poll()));
                }
            }
            queue.add(s.charAt(index));
        }
        while (!queue.isEmpty()) {
            result.append(numberToChar(queue.poll()));
        }
        return result.toString();
    }

    private char numberToChar(char a, char b) {
        return numberToChar(10 * (a - '0') + (b - '0'));
    }

    private char numberToChar(char digit) {
        return numberToChar(digit - '0');
    }

    private char numberToChar(int digit) {
        return (char) (digit + 'a' - 1);
    }
}
