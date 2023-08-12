// https://leetcode.com/problems/number-of-beautiful-pairs/description
// N: length of number array
// m: size of average number
// T: O(N * log(m))
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class NumberOfBeautifulPairs {
    public int countBeautifulPairs(int[] array) {
        final Map<Integer, Integer> firstDigitFrequencies = new HashMap<>();
        int pairs = 0;
        for (int element : array) {
            final int firstDigit = getFirstDigit(element);
            final int lastDigit = getLastDigit(element);
            for (Map.Entry<Integer, Integer> entry : firstDigitFrequencies.entrySet()) {
                if (gcd(lastDigit, entry.getKey()) == 1) {
                    pairs += entry.getValue();
                }
            }
            firstDigitFrequencies.put(firstDigit, firstDigitFrequencies.getOrDefault(firstDigit, 0) + 1);
        }
        return pairs;
    }

    private int getFirstDigit(int number) {
        return (number + "").charAt(0) - '0';
    }

    private int getLastDigit(int number) {
        return number % 10;
    }

    // T: O(log(max(a, b)))
    // S: O(log(max(a, b)))
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
