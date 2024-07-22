// https://leetcode.com/problems/insert-delete-getrandom-o1

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1 {
    static class RandomizedSet {
        private final Random random = new Random();
        private final List<Integer> list = new ArrayList<>();
        private final Map<Integer, Integer> indexMapping = new HashMap<>();

        public boolean insert(int val) {
            if (indexMapping.containsKey(val)) {
                return false;
            }
            list.add(val);
            indexMapping.put(val, list.size() - 1);
            return true;
        }

        private int last() {
            return this.list.getLast();
        }

        public boolean remove(int val) {
            if (!indexMapping.containsKey(val)) {
                return false;
            }
            final int index = indexMapping.get(val);
            indexMapping.put(last(), index);
            indexMapping.remove(val);
            list.set(index, last());
            list.removeLast();
            return true;
        }

        public int getRandom() {
            final int randomIndex = random.nextInt(list.size());
            return list.get(randomIndex);
        }
    }
}
