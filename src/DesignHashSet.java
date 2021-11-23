import java.util.LinkedList;
import java.util.Queue;

public class DesignHashSet {
    class MyHashSet {

        private static final int INITIAL_SIZE = 100;
        private final Bucket[] buckets;
        private int size = 0;

        public MyHashSet() {
            this.buckets = new Bucket[INITIAL_SIZE];
            initializeBuckets();
        }

        public MyHashSet(int initialSize) {
            this.buckets = new Bucket[initialSize];
            initializeBuckets();
        }

        public void add(int element) {
            int hash = element % buckets.length;
            if (!buckets[hash].contains(element)) {
                buckets[hash].add(element);
                this.size++;
            }
        }

        public void remove(int element) {
            buckets[element % buckets.length].remove(element);
        }

        public boolean contains(int element) {
            return buckets[element % buckets.length].contains(element);
        }

        private void initializeBuckets() {
            for (int index = 0 ; index < buckets.length ; index++) {
                buckets[index] = new Bucket();
            }
        }

        private static class Bucket {
            Queue<Integer> list = new LinkedList<>();

            public boolean contains(int element) {
                return list.contains(element);
            }

            public void add(int element) {
                if (!this.contains(element)) {
                    list.add(element);
                }
            }

            public void remove(int element) {
                list.remove(element);
            }
        }
    }
}
