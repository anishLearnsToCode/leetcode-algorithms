import java.util.HashSet;
import java.util.Set;

public class NumberOfDifferentIntegersInString {
    public int numDifferentIntegers(String word) {
        final Set<String> uniqueIntegers = integersInString(word);
        return uniqueIntegers.size();
    }

    private Set<String> integersInString(String s) {
        final Set<String> integers = new HashSet<>();
        boolean inNumber = false;
        StringBuilder current = new StringBuilder();
        for (int index = 0 ; index < s.length() ; index++) {
            if (Character.isDigit(s.charAt(index))) {
                if (!inNumber) inNumber = true;
                current.append(s.charAt(index) == '0' && current.length() == 0 ? "" : s.charAt(index));
                if (index == s.length() - 1) integers.add(current.toString());
            } else if (inNumber) {
                inNumber = false;
                integers.add(current.toString());
                current = new StringBuilder();
            }
        }
        return integers;
    }
}
