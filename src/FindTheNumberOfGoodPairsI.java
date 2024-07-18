// https://leetcode.com/problems/find-the-number-of-good-pairs-i
// x = largest possible integer
// T: O(n*sqrt(x) + m)
// S: O(n + m)

import java.util.HashMap;
import java.util.Map;

public class FindTheNumberOfGoodPairsI {
    public int numberOfPairs(int[] array1, int[] array2, int k) {
        final Map<Integer, Integer> dividends = getDividendFrequencies(array1, k);
        final Map<Integer, Integer> divisors = getElementFrequencies(array2);
        int pairs = 0;

        for (Map.Entry<Integer, Integer> entry : dividends.entrySet()) {
            final int dividend = entry.getKey();
            final int frequency = entry.getValue();

            for (int i = 1 ; i * i <= dividend ; i++) {
                if (dividend % i == 0) {
                    pairs += frequency * divisors.getOrDefault(i, 0);
                    if (i != dividend / i) {
                        pairs += frequency * divisors.getOrDefault(dividend / i, 0);
                    }
                }
            }
        }

        return pairs;
    }

    private static Map<Integer, Integer> getElementFrequencies(int[] array) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }

    private static Map<Integer, Integer> getDividendFrequencies(int[] array, int k) {
        final Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            if (element % k == 0) {
                int quotient = element / k;
                frequencies.put(quotient, frequencies.getOrDefault(quotient, 0) + 1);
            }
        }
        return frequencies;
    }
}
