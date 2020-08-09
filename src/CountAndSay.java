import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountAndSay {
    private static String countAndSay(int number) {
        if (number == 1) {
            return "1";
        }

        String previous = countAndSay(number - 1);
        List<Pair> pairs = getFrequencies(previous);
        StringBuilder result = new StringBuilder();
        for (Pair pair : pairs) {
            result.append(pair.frequency).append(pair.character);
        }
        return result.toString();
    }

    private static List<Pair> getFrequencies(String string) {
        char current = string.charAt(0);
        int frequency = 0;
        List<Pair> result = new ArrayList<>();

        for (int index = 0 ; index < string.length() ; index++) {
            if (string.charAt(index) != current) {
                result.add(new Pair(current, frequency));
                frequency = 1;
                current = string.charAt(index);
            } else {
                frequency++;
            }
        }

        result.add(new Pair(current, frequency));
        return result;
    }

    private static class Pair {
        final char character;
        final int frequency;

        Pair(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }
}
