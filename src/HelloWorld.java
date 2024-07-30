import java.util.*;

public class HelloWorld {
    private record Edge(int vertex, int time) {}

    public int networkDelayTime(int[][] times, int n, int k) {
        final Map<Integer, Map<Integer, Integer>> graph = createGraph(times);
        final Map<Integer, Integer> delayTimes = dijkstra(graph, k);
        if (delayTimes.size() != n) {
            return -1;
        }
        return delayTimes.values().stream().max(Integer::compare).get();
    }

    // T: O(E), S: O(E)
    private static Map<Integer, Map<Integer, Integer>> createGraph(int[][] edges) {
        final Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            final int from = edge[0], to = edge[1], weight = edge[2];
            final Map<Integer, Integer> neighbours = graph.getOrDefault(from, new HashMap<>());
            neighbours.put(to, weight);
            graph.putIfAbsent(from, neighbours);
        }
        return graph;
    }

    // T: O(V + E logV)
    private static Map<Integer, Integer> dijkstra(Map<Integer, Map<Integer, Integer>> graph, int start) {
        final Map<Integer, Integer> distances = new HashMap<>();
        final Queue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.time));
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            final Edge edge = queue.poll();
            if (edge.time >= distances.getOrDefault(edge.vertex, Integer.MAX_VALUE)) {
                continue;
            }

            distances.put(edge.vertex, edge.time);

            for (Map.Entry<Integer, Integer> entry : graph.getOrDefault(edge.vertex, new HashMap<>()).entrySet()) {
                final int neighbour = entry.getKey(), time = entry.getValue();
                queue.add(new Edge(neighbour, edge.time + time));
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        int[] b = new int[] {1, 2, 3};
        int[] a = b;
        System.out.println(Arrays.toString(a));
        b = new int[] {5, 6, 7};
        System.out.println(Arrays.toString(a));

    }
}