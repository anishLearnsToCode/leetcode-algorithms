// https://leetcode.com/problems/evaluate-division
// N = |equations|, M = |queries|
// T: O(N + M*N) = O(MN)
// S: O(N + M)

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivision {
    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        final Map<String, Map<String, Double>> graph = createGraph(equations, values);
        return computeQueries(graph, queries);
    }

    private static Map<String, Map<String, Double>> createGraph(List<List<String>> equations, double[] values) {
        final Map<String, Map<String, Double>> result = new HashMap<>();
        for (int i = 0 ; i < equations.size() ; i++) {
            final List<String> equation = equations.get(i);
            final String dividend = equation.get(0), divisor = equation.get(1);
            result.putIfAbsent(dividend, new HashMap<>());
            result.putIfAbsent(divisor, new HashMap<>());
            result.get(dividend).put(divisor, values[i]);
            result.get(divisor).put(dividend, 1 / values[i]);
        }
        return result;
    }

    private static double[] computeQueries(Map<String, Map<String, Double>> graph, List<List<String>> queries) {
        final double[] result = new double[queries.size()];
        for (int i = 0 ; i < queries.size() ; i++) {
            final List<String> query = queries.get(i);
            final String dividend = query.get(0), divisor = query.get(1);
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                result[i] = -1;
            } else if (dividend.equals(divisor)) {
                result[i] = 1;
            } else {
                result[i] = computeDfs(graph, dividend, divisor);
            }
        }
        return result;
    }

    private static double computeDfs(Map<String, Map<String, Double>> graph, String dividend, String divisor) {
        return dfs(graph, dividend, divisor, 1, new HashSet<>());
    }

    private static double dfs(Map<String, Map<String, Double>> graph, String current, String target, double product, Set<String> visited) {
        if (current.equals(target)) {
            return product;
        }
        if (visited.contains(current)) {
            return -1;
        }
        visited.add(current);
        for (Map.Entry<String, Double> edges : graph.get(current).entrySet()) {
            final double result = dfs(graph, edges.getKey(), target, product * edges.getValue(), visited);
            if (result != -1) {
                return result;
            }
        }
        return -1;
    }
}
