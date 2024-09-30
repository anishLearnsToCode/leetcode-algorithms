// https://leetcode.com/problems/moving-average-from-data-stream
// N: number of calls to next(), M: max window size
// T: O(N)
// S: O(M)

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {
}


class MovingAverage {
    final int windowSize;
    final Queue<Integer> queue = new LinkedList<>();
    double windowSum = 0;

    // T: O(1)
    public MovingAverage(int size) {
        windowSize = size;
    }

    // T: O(1)
    // S: O(1)
    public double next(int val) {
        queue.add(val);
        final int toRemove = (queue.size() > windowSize && !queue.isEmpty()) ? queue.poll() : 0;
        windowSum += val - toRemove;
        return windowSum / queue.size();
    }
}