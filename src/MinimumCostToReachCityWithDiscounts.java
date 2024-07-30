// https://leetcode.com/problems/minimum-cost-to-reach-city-with-discounts
// T: O((N * K + E) log(N * K))
// S: O(N * K + E)

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostToReachCityWithDiscounts {
    private record Info(int vertex, int cost, int discounts) {}

    public static int minimumCost(int n, int[][] highways, int discounts) {
        final Map<Integer, Map<Integer, Integer>> graph = createGraph(highways);
        final int[][] minCosts = dijkstra(n, graph, discounts);
        return minCost(minCosts[n -1]);
    }

    // N = n, K = |discounts|, E
    // T: O(N * K + E log(N * K)) = O((N * K + E) log(N * K))
    // S: O(N * K + E)
    private static int[][] dijkstra(int n, Map<Integer, Map<Integer, Integer>> graph, int discount) {
        final int[][] dp = initializeDp(n, discount);
        final Queue<Info> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        queue.add(new Info(0, 0, discount));

        while (!queue.isEmpty()) {
            final Info info = queue.poll();
            if (dp[info.vertex][info.discounts] <= info.cost) {
                continue;
            }

            dp[info.vertex][info.discounts] = info.cost;

            for (Map.Entry<Integer, Integer> entry : graph.getOrDefault(info.vertex, new HashMap<>()).entrySet()) {
                final int vertex = entry.getKey(), cost = entry.getValue();
                queue.add(new Info(vertex, info.cost + cost, info.discounts));
                if (info.discounts > 0) {
                    queue.add(new Info(vertex, info.cost + cost / 2, info.discounts - 1));
                }
            }
        }

        return dp;
    }

    private static int[][] initializeDp(int n, int discounts) {
        final int[][] dp = new int[n][discounts + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        return dp;
    }

    private static int minCost(int[] array) {
        final int result = Arrays.stream(array).min().getAsInt();
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        return result;
    }

    private static Map<Integer, Map<Integer, Integer>> createGraph(int[][] edges) {
        final Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            final int from = edge[0], to = edge[1], cost = edge[2];
            final Map<Integer, Integer> fromNeighbours = graph.getOrDefault(from, new HashMap<>());
            final Map<Integer, Integer> toNeighbours = graph.getOrDefault(to, new HashMap<>());
            fromNeighbours.put(to, cost);
            toNeighbours.put(from, cost);
            graph.putIfAbsent(from, fromNeighbours);
            graph.putIfAbsent(to, toNeighbours);
        }
        return graph;
    }
}
