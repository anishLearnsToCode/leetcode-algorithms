import java.util.HashMap;
import java.util.Map;

public class CountLargestGroup {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> sumOfDigitsFrequencies = getFrequenciesOfSumOfDigits(n);
        int largestGroupSize = 0, largestGroupFrequency = 0;
        for (int groupSize : sumOfDigitsFrequencies.values()) {
            if (groupSize > largestGroupSize) {
                largestGroupSize = groupSize;
                largestGroupFrequency = 1;
            } else if (largestGroupSize == groupSize) {
                largestGroupFrequency++;
            }
        }
        return largestGroupFrequency;
    }

    private Map<Integer, Integer> getFrequenciesOfSumOfDigits(int N) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int number = 1 ; number <= N ; number++) {
            int sumOfDigits = sumOfDigits(number);
            frequencies.put(sumOfDigits, frequencies.getOrDefault(sumOfDigits, 0) + 1);
        }
        return frequencies;
    }

    private int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /=  10;
        }
        return sum;
    }
}
