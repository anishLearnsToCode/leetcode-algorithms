import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        int pairs= 0;
        if (k == 0) {
            Map<Integer, Integer> frequencies = new HashMap<>();
            for (int number : nums) {
                frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);
            }
            for (int frequency : frequencies.values()) {
                pairs += frequency > 1 ? 1 : 0;
            }
        } else {
            Set<Integer> numbers = new HashSet<>();
            for (int number : nums) {
                if (!numbers.contains(number)) {
                    pairs += numbers.contains(number - k) ? 1 : 0;
                    pairs += numbers.contains(number + k) ? 1 : 0;
                    numbers.add(number);
                }
            }
        }
        return pairs;
    }
}
