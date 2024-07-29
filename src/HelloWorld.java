// T: O(V + EllogV)
// S: O(E + V)

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;


public class HelloWorld {
    private static final record Pair(int vertex, int distance) {}

    public int networkDelayTime(int[][] times, int n, int k) {
        final Map<Integer, Map<Integer, Integer>> graph = createGraph(times);
        final Map<Integer, Integer> distances = new HashMap<>();
        final Queue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));

        minHeap.add(new Pair(k, 0));

        while (!minHeap.isEmpty()) {
            final Pair pair = minHeap.poll();
            final int vertex = pair.vertex, distanceToVertex = pair.distance;
            final int currentVertexTime = distances.getOrDefault(vertex, Integer.MAX_VALUE);

            if (currentVertexTime < distanceToVertex) {
                continue;
            }

            distances.put(vertex, distanceToVertex);

            for (Map.Entry<Integer, Integer> entry : graph.getOrDefault(pair.vertex, new HashMap<>()).entrySet()) {
                final int neighbour = entry.getKey(), distance = entry.getValue();
                final int currentMinDistance = distances.getOrDefault(neighbour, Integer.MAX_VALUE);
                final int minDistance = Math.min(currentMinDistance, distances.get(pair.vertex) + distance);

                if (minDistance < currentMinDistance) {
                    distances.put(neighbour, minDistance);
                    minHeap.add(new Pair(neighbour, minDistance));
                }
            }
        }

        return minTimeRequired(distances, n);
    }

    private static Map<Integer, Map<Integer, Integer>> createGraph(int[][] edges) {
        final Map<Integer, Map<Integer, Integer>> result = new HashMap<>();
        for (int[] edge : edges) {
            final int from = edge[0], to = edge[1], weight = edge[2];
            final Map<Integer, Integer> weights = result.getOrDefault(from, new HashMap<>());
            weights.put(to, weight);
            result.putIfAbsent(from, weights);
        }
        return result;
    }

    private static int minTimeRequired(Map<Integer, Integer> distances, int n) {
        if (distances.size() != n) {
            return -1;
        }
        return distances.values().stream().max(Integer::compareTo).get();
    }
}