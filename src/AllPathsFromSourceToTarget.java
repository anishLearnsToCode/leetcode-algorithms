// https://leetcode.com/problems/all-paths-from-source-to-target
// maximum edges for DAG = V-1, possible paths = 2^(V-1), for every path we clone path O(V)
// T: O(2^V * V)
// S: O(V)

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        final List<List<Integer>> result = new ArrayList<>();
        final int n = graph.length;
        dfs(graph, 0, n - 1, new ArrayList<>() {{ add(0); }}, result);
        return result;
    }

    private static void dfs(int[][] graph, int current, int target, List<Integer> path, List<List<Integer>> result) {
        if (current == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int edge : graph[current]) {
            path.add(edge);
            dfs(graph, edge, target, path, result);
            path.removeLast();
        }
    }
}
