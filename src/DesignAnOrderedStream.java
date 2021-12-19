import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DesignAnOrderedStream {
    class OrderedStream {
        private final String[] array;
        private int pointer = 1;

        public OrderedStream(int n) {
            this.array = new String[n + 1];
        }

        public List<String> insert(int key, String value) {
            array[key] = value;
            if (pointer == key) {
                final List<String> list = new ArrayList<>();
                while (pointer < array.length && array[pointer] != null) {
                    list.add(array[pointer++]);
                }
                return list;
            }
            return Collections.emptyList();
        }
    }
}
