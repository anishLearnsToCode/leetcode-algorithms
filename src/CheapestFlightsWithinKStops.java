// https://leetcode.com/problems/cheapest-flights-within-k-stops
// T: O((N + E) * K)
// S: O(N)

import java.util.Arrays;

public class CheapestFlightsWithinKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int[] distances = bellmanFord(flights, n, k, src);
        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }

    // T: O(N * K + E * K) = T: O((N + E) * K) S: O(N)
    private static int[] bellmanFord(int[][] edges, int n, int k, int source) {
        int[] distances = initializeDistances(n);
        distances[source] = 0;
        for (int i = 0 ; i < k + 1 ; i++) {
            final int[] temp = cloneArray(distances);
            for (int[] edge : edges) {
                final int from = edge[0], to = edge[1], weight = edge[2];
                if (distances[from] != Integer.MAX_VALUE) {
                    temp[to] = Math.min(temp[to], distances[from] + weight);
                }
            }
            distances = temp;
        }
        return distances;
    }

    // T: O(N), S: O(N)
    private static int[] initializeDistances(int n) {
        final int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        return distances;
    }

    // T: O(N), S: O(N)
    private static int[] cloneArray(int[] array) {
        final int[] result = new int[array.length];
        System.arraycopy(array, 0, result, 0, array.length);
        return result;
    }
}
