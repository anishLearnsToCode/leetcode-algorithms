// https://leetcode.com/problems/network-delay-time
// Single source shortest path algorithm (Dijkstra's Algorithm)
// T: O(E log(N) for dijkstra + N for searching max val)
// S: O(E + N)

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class NetworkDelayTime {
    private record Node(int value, long time) { }

    public int networkDelayTime(int[][] times, int n, int k) {
        final Map<Integer, Map<Integer, Integer>> graph = createDirectedGraphFrom(times);
        final long[] minTimeTaken = getMinTimeTakenArray(n, k);
        final Queue<Node> queue = new PriorityQueue<Node>(Comparator.comparing(Node::time));
        queue.add(new Node(k, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (!graph.containsKey(node.value)) continue;
            Map<Integer, Integer> vertexNode = graph.get(node.value);
            for (int adjacent : vertexNode.keySet()) {
                if (minTimeTaken[node.value - 1] + vertexNode.get(adjacent) < minTimeTaken[adjacent - 1]) {
                    minTimeTaken[adjacent - 1] = minTimeTaken[node.value - 1] + vertexNode.get(adjacent);
                    queue.add(new Node(adjacent, minTimeTaken[adjacent - 1]));
                }
            }
        }

        return allAreReached(minTimeTaken) ? (int) Arrays.stream(minTimeTaken).max().getAsLong() : -1;
    }

    private Map<Integer, Map<Integer, Integer>> createDirectedGraphFrom(int[][] times) {
        final Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] time : times) {
            int start = time[0];
            int destination = time[1];
            int delay = time[2];

            graph.putIfAbsent(start, new HashMap<>());
            graph.get(start).put(destination, delay);
        }
        return graph;
    }

    private long[] getMinTimeTakenArray(int length, int start) {
        long[] array = new long[length];
        for (int i = 0 ; i < length ; i++) {
            array[i] = Integer.MAX_VALUE;
        }
        array[start - 1] = 0;
        return array;
    }

    private boolean allAreReached(long[] array) {
        for (long val : array) {
            if (val == Integer.MAX_VALUE) return false;
        }
        return true;
    }
}
