import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class DesignHashMap {
    class MyHashMap {

        private final int initialSize = 100;
        private final Bucket[] buckets = new Bucket[initialSize];

        public MyHashMap() {
            for (int index = 0 ; index < buckets.length ; index++) {
                buckets[index] = new Bucket();
            }
        }

        public void put(int key, int value) {
            int hashCode = key % buckets.length;
            buckets[hashCode].put(key, value);
        }

        public int get(int key) {
            return buckets[key % buckets.length].get(key);
        }

        public void remove(int key) {
            buckets[key % buckets.length].remove(key);
        }

        private class Bucket {
            Queue<Pair> list = new LinkedList<>();


            public boolean contains(int element) {
                return list.stream().anyMatch(pair -> pair.key == element);
            }

            public void put(int key, int value) {
                if (contains(key)) {
                    Pair match = list.stream().filter(pair -> pair.key == key).findFirst().get();
                    match.value = value;
                } else {
                    list.add(new Pair(key, value));
                }
            }

            public int get(int key) {
                return contains(key) ? list.stream().filter(pair -> pair.key == key).findFirst().get().value : -1;
            }

            public void remove(int key) {
                if (contains(key)) {
                    list.remove(new Pair(key, get(key)));
                }
            }
        }

        private class Pair {
            private final int key;
            private int value;

            Pair(int key, int value) {
                this.key = key;
                this.value = value;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Pair pair = (Pair) o;
                return key == pair.key && value == pair.value;
            }

            @Override
            public int hashCode() {
                return Objects.hash(key, value);
            }
        }
    }
}
