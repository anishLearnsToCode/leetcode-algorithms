// https://leetcode.com/problems/finding-3-digit-even-numbers
// T: O(N)
// S: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Finding3DigitEvenNumbers {
    public int[] findEvenNumbers(int[] digits) {
        final Map<Integer, Integer> frequencies = getFrequency(digits);
        final List<Integer> numbers = new ArrayList<>();
        for (int number = 100 ; number <= 999 ; number += 2) {
            if (canBeFormed(number, frequencies)) {
                numbers.add(number);
            }
        }
        return toArray(numbers);
    }

    private boolean canBeFormed(int number, Map<Integer, Integer> digits) {
        final Map<Integer, Integer> numberDigits = getFrequency(number);
        for (Map.Entry<Integer, Integer> entry : numberDigits.entrySet()) {
            if (digits.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private int[] toArray(List<Integer> list) {
        final int[] array = new int[list.size()];
        for (int i = 0 ; i < list.size() ; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    private Map<Integer, Integer> getFrequency(int[] array) {
        final Map<Integer, Integer> frequency = new HashMap<>();
        for (int element : array) {
            frequency.put(element, frequency.getOrDefault(element, 0) + 1);
        }
        return frequency;
    }

    private Map<Integer, Integer> getFrequency(int number) {
        final Map<Integer, Integer> frequency = new HashMap<>();
        while (number > 0) {
            int digit = number % 10;
            frequency.put(digit, frequency.getOrDefault(digit, 0) + 1);
            number /= 10;
        }
        return frequency;
    }
}
