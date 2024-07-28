// https://leetcode.com/problems/all-paths-from-source-lead-to-destination
// T: O(V + E)
// S: O(V)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllPathsFromSourceLeadToDestination {
    // We don't use the state WHITE as such anywhere. Instead, the "null" value in the states array below is a substitute for WHITE.
    enum Color { GRAY, BLACK };

    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        Map<Integer, Set<Integer>> graph = buildGraph(edges);
        return leadsToDestination(graph, source, destination, new Color[n]);
    }

    private boolean leadsToDestination(Map<Integer, Set<Integer>> graph, int node, int target, Color[] states) {
        // If the state is GRAY, this is a backward edge and hence, it creates a loop.
        if (states[node] != null) {
            return states[node] == Color.BLACK;
        }

        // If this is a leaf node, it should be equal to the destination.
        if (!graph.containsKey(node)) {
            return node == target;
        }

        // Now, we are processing this node. So we mark it as GRAY
        states[node] = Color.GRAY;

        for (int next : graph.get(node)) {
            if (!leadsToDestination(graph, next, target, states)) {
                return false;
            }
        }

        states[node] = Color.BLACK;
        return true;
    }

    private Map<Integer, Set<Integer>> buildGraph(int[][] edges) {
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            final int from = edge[0], to = edge[1];
            final Set<Integer> neighbours = graph.getOrDefault(from, new HashSet<>());
            neighbours.add(to);
            graph.putIfAbsent(from, neighbours);
        }
        return graph;
    }
}
