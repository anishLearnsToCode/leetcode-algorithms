import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {
    class KthLargest {

        private final Queue<Integer> heap = new PriorityQueue<>();
        private final int heapSize;

        public KthLargest(int k, int[] nums) {
            heapSize = k;
            for (int element : nums) {
                heap.add(element);
            }
            while (heap.size() > heapSize) {
                heap.poll();
            }
        }

        public int add(int val) {
            heap.add(val);
            while (heap.size() > heapSize) {
                heap.poll();
            }
            return heap.peek();
        }
    }
}
