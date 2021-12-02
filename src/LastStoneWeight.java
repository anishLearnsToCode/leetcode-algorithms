import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) maxHeap.add(stone);
        int stone1, stone2;
        while (maxHeap.size() > 1) {
            stone1 = maxHeap.poll();
            stone2 = maxHeap.poll();
            if (stone1 != stone2) {
                maxHeap.add(Math.abs(stone1 - stone2));
            }
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}
