// https://leetcode.com/problems/minimum-height-trees
// T: O(N)
// S: O(N)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0) return new ArrayList<>();
        if (n == 1) return new ArrayList<>() {{ add(0); }};

        final Map<Integer, Set<Integer>> graph = createGraph(edges);
        return minHeightTreeRoots(graph);
    }

    // T: O(N), S: O(N)
    private static List<Integer> minHeightTreeRoots(Map<Integer, Set<Integer>> graph) {
        final int[] degree = computeDegree(graph);
        Set<Integer> leafNodes = addLeafNodes(degree);

        while (graph.size() > 2) {
            final Set<Integer> newLeafNodes = new HashSet<>();
            for (int leafNode : leafNodes) {
                degree[leafNode]--;
                for (int neighbour : graph.get(leafNode)) {
                    degree[neighbour]--;
                    if (degree[neighbour] == 1) {
                        newLeafNodes.add(neighbour);
                    }
                }
                graph.remove(leafNode);
            }
            leafNodes = newLeafNodes;
        }

        return new ArrayList<>(graph.keySet());
    }

    // T: O(N), S: O(N)
    private static Set<Integer> addLeafNodes(int[] degree) {
        final Set<Integer> leafNodes = new HashSet<>();
        for (int i = 0 ; i < degree.length ; i++) {
            if (degree[i] == 1) {
                leafNodes.add(i);
            }
        }
        return leafNodes;
    }

    // T: O(N), S: O(N)
    private static int[] computeDegree(Map<Integer, Set<Integer>> graph) {
        final int[] degree = new int[graph.size()];
        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            degree[entry.getKey()] = entry.getValue().size();
        }
        return degree;
    }

    // T: O(N), S: O(N)
    private static Map<Integer, Set<Integer>> createGraph(int[][] edges) {
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            final int from = edge[0], to = edge[1];
            final Set<Integer> fromSet = graph.getOrDefault(from, new HashSet<>());
            final Set<Integer> toSet = graph.getOrDefault(to, new HashSet<>());
            fromSet.add(to);
            toSet.add(from);
            graph.putIfAbsent(from, fromSet);
            graph.putIfAbsent(to, toSet);
        }
        return graph;
    }
}
