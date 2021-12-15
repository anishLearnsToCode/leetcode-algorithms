import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindTheLuckyIntegerInAnArray {
    public int findLucky(int[] array) {
        Map<Integer, Integer> frequencies = getFrequencies(array);
        Queue<Integer> luckyIntegers = getLuckyIntegers(frequencies);
        if (luckyIntegers.isEmpty()) return -1;
        return luckyIntegers.poll();
    }

    private Map<Integer, Integer> getFrequencies(int[] array) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int element : array) {
            frequencies.put(element, frequencies.getOrDefault(element, 0) + 1);
        }
        return frequencies;
    }

    private Queue<Integer> getLuckyIntegers(Map<Integer, Integer> frequencies){
        Queue<Integer> luckyNumbers = new PriorityQueue<>(Comparator.reverseOrder());
        for (Map.Entry<Integer, Integer> entry : frequencies.entrySet()) {
            if (entry.getKey() == entry.getValue()) {
                luckyNumbers.add(entry.getValue());
            }
        }
        return luckyNumbers;
    }
}
