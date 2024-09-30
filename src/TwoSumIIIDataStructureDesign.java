import java.util.HashMap;
import java.util.Map;

public class TwoSumIIIDataStructureDesign {
    static class TwoSum {
        private final Map<Integer, Integer> map = new HashMap<>();

        // T: O(1)
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        // N: number of unique elements we have seen so far
        // T: O(N)
        public boolean find(int sum) {
            for (int current : map.keySet()) {
                final int required = sum - current;
                if (required == current) {
                    if (map.get(required) >= 2) {
                        return true;
                    } else {
                        continue;
                    }
                }

                if (map.containsKey(required)) {
                    return true;
                }
            }

            return false;
        }
    }
}
