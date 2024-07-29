// https://leetcode.com/problems/path-with-maximum-probability
// T: O(E + N + E logN)
// S: O(E + N)

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaximumProbability {
    private record Pair(int vertex, double probability) {}

    public static double maxProbability(int n, int[][] edges, double[] probabilities, int start, int end) {
        final Map<Integer, Map<Integer, Double>> graph = createGraph(edges, probabilities);
        final Map<Integer, Double> distances = dijkstra(graph, start, end);
        return distances.getOrDefault(end, 0.0);
    }

    private static Map<Integer, Map<Integer, Double>> createGraph(int[][] edges, double[] probabilities) {
        final Map<Integer, Map<Integer, Double>> graph = new HashMap<>();
        int k = 0;
        for (int[] edge : edges) {
            final int from = edge[0], to = edge[1];
            final double weight = probabilities[k++];
            final Map<Integer, Double> fromNeighbours = graph.getOrDefault(from, new HashMap<>());
            final Map<Integer, Double> toNeighbours = graph.getOrDefault(to, new HashMap<>());
            fromNeighbours.put(to, weight);
            toNeighbours.put(from, weight);
            graph.putIfAbsent(from, fromNeighbours);
            graph.putIfAbsent(to, toNeighbours);
        }
        return graph;
    }

    private static Map<Integer, Double> dijkstra(Map<Integer, Map<Integer, Double>> graph, int start, int end) {
        final Map<Integer, Double> distances = new HashMap<>();
        final Queue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingDouble(a -> a.probability));
        minHeap.add(new Pair(start, 1));
        distances.put(start, 1.0);

        while (!minHeap.isEmpty()) {
            final Pair pair = minHeap.poll();

            if (pair.vertex == end) {
                break;
            }

            for (Map.Entry<Integer, Double> neighbour : graph.getOrDefault(pair.vertex, new HashMap<>()).entrySet()) {
                final int edgeVertex = neighbour.getKey();
                final double edgeWeight = neighbour.getValue();
                final double currentProbability = distances.getOrDefault(edgeVertex, 0.0);
                final double edgeProbability = Math.max(
                        currentProbability,
                        pair.probability * edgeWeight
                );
                if (edgeProbability > currentProbability) {
                    distances.put(edgeVertex, edgeProbability);
                    minHeap.add(new Pair(edgeVertex, edgeProbability));
                }
            }
        }

        return distances;
    }
}
