// https://leetcode.com/problems/take-gifts-from-the-richest-pile
// T: O(k * log(N))
// S: O(N)

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class TakeGiftsFromTheRichestPile {
    public long pickGifts(int[] gifts, int k) {
        final Queue<Integer> maxHeap = maHeapFrom(gifts);

        for (int i = 0 ; i < k ; i++) {
            final int maxPile = maxHeap.poll();
            final int giftsToLeaveBehind = (int) Math.max(Math.sqrt(maxPile), 0);
            maxHeap.add(giftsToLeaveBehind);
        }

        return sum(maxHeap);
    }

    private long sum(Queue<Integer> heap) {
        long sum = 0;
        while (!heap.isEmpty()) {
            sum += heap.poll();
        }
        return sum;
    }

    private Queue<Integer> maHeapFrom(int[] array) {
        final Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int element : array) {
            maxHeap.add(element);
        }
        return maxHeap;
    }
}
