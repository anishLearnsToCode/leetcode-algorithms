// https://leetcode.com/problems/reconstruct-itinerary
// E = |flights|, V = |airports| N = E / V
// T: O(V * NlogN) = O(E log(E / V))
// S: O(V + E)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        final Map<String, Queue<String>> graph = createGraph(tickets);
        final List<String> result = new ArrayList<>();
        dfs(graph, "JFK", result);
        return result.reversed();
    }

    private static void dfs(Map<String, Queue<String>> graph, String current, List<String> result) {
        final Queue<String> queue = graph.getOrDefault(current, new PriorityQueue<>());
        while (!queue.isEmpty()) {
            final String to = queue.poll();
            dfs(graph, to, result);
        }
        result.add(current);
    }

    private static Map<String, Queue<String>> createGraph(List<List<String>> tickets) {
        final Map<String, Queue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            final String from = ticket.get(0), to = ticket.get(1);
            final Queue<String> queue = graph.getOrDefault(from, new PriorityQueue<>());
            queue.add(to);
            graph.putIfAbsent(from, queue);
        }
        return graph;
    }
}
