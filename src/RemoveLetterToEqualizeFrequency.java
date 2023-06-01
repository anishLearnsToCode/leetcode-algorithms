// https://leetcode.com/problems/remove-letter-to-equalize-frequency
// T: O(|word|)
// S: O(1)

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RemoveLetterToEqualizeFrequency {
    public boolean equalFrequency(String word) {
        final Map<Character, Integer> letterFrequency = getFrequencies(word);
        final Map<Integer, Integer> numberFrequency = getFrequencies(letterFrequency.values());

        if (letterFrequency.size() == 1) {
            return true;
        }

        if (numberFrequency.size() == 1 && numberFrequency.keySet().iterator().next() == 1) {
            return true;
        }

        if (numberFrequency.size() == 1 || numberFrequency.size() > 2) {
            return false;
        }

        final Iterator<Integer> iterator = numberFrequency.keySet().iterator();
        final int first = iterator.next(), second = iterator.next();
        final int smallerNum = Math.min(first, second);
        final int largerNum = Math.max(first, second);
        final int smallerNumFreq = numberFrequency.get(smallerNum);
        final int largerNumFreq = numberFrequency.get(largerNum);

        return ((largerNum - smallerNum == 1) && largerNumFreq == 1) || (smallerNum == 1 && smallerNumFreq == 1);
    }

    private Map<Character, Integer> getFrequencies(String string) {
        final Map<Character, Integer> result = new HashMap<>();
        for (int index = 0 ; index < string.length() ; index++) {
            char letter = string.charAt(index);
            result.put(letter, result.getOrDefault(letter, 0) + 1);
        }
        return result;
    }

    private Map<Integer, Integer> getFrequencies(Iterable<Integer> iterable) {
        final Map<Integer, Integer> result = new HashMap<>();
        for (int value : iterable) {
            result.put(value, result.getOrDefault(value, 0) + 1);
        }
        return result;
    }
}
