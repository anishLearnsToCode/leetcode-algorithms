// https://leetcode.com/problems/min-cost-to-connect-all-points
// P = |points|, E = P^2
// T: O(E logE + E al(P)) al = inverse Ackerman function
// S: O(P + E) = S(E)

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MinCostToConnectAllPoints {
    private static class DisjointSet {
        private final int[] roots, rank;

        DisjointSet(int size) {
            roots = new int[size];
            rank = new int[size];
            for (int i = 0 ; i < size ; i++) {
                roots[i] = i;
                rank[i] = i;
            }
        }

        public int find(int num) {
            if (num == roots[num]) {
                return num;
            }
            return roots[num] = find(roots[num]);
        }

        public boolean areConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            final int rootX = find(x), rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] > rank[rootY]) {
                roots[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                roots[rootX] = rootY;
            } else {
                roots[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    // Kruskal's algorithm
    public int minCostConnectPoints(int[][] points) {
        final List<int[]> edges = createEdges(points);
        final DisjointSet disjointSet = new DisjointSet(points.length);
        edges.sort(Comparator.comparingInt(a -> a[2]));

        int minCost = 0;

        for (int[] edge : edges) {
            final int from = edge[0], to = edge[1], weight = edge[2];
            if (!disjointSet.areConnected(from, to)) {
                disjointSet.union(from, to);
                minCost += weight;
            }
        }

        return minCost;
    }

    private static List<int[]> createEdges(int[][] points) {
        final List<int[]> edges = new ArrayList<>();
        for (int i = 0 ; i < points.length ; i++) {
            for (int j = i + 1 ; j < points.length ; j++) {
                edges.add(new int[] { i, j, manhattanDistance(points[i], points[j]) });
            }
        }
        return edges;
    }

    private static int manhattanDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}
