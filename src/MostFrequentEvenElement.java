// https://leetcode.com/problems/most-frequent-even-element
// T: O(N)
// S: O(N)

import java.util.HashMap;
import java.util.Map;

public class MostFrequentEvenElement {
    public int mostFrequentEven(int[] nums) {
        final Map<Integer, Integer> evenFrequencies = new HashMap<>();
        int maxFrequency = 0, smallestEvenNumber = -1;

        for (int element : nums) {
            if (element % 2 == 1) {
                continue;
            }

            evenFrequencies.put(element, evenFrequencies.getOrDefault(element, 0) + 1);
            if (evenFrequencies.get(element) > maxFrequency) {
                maxFrequency = evenFrequencies.get(element);
                smallestEvenNumber = element;
            } else if (evenFrequencies.get(element) == maxFrequency) {
                smallestEvenNumber = Math.min(smallestEvenNumber, element);
            }
        }

        return smallestEvenNumber;
    }
}
