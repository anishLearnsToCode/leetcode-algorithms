// https://leetcode.com/problems/optimize-water-distribution-in-a-village
// N = n, E = |pipes|
// T: O(N + (N + E) log(N + E) + E al(N)) = O((N + E) log(N + E)) al = inverse Ackermann function
// S: O(N + E)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OptimizeWaterDistributionInAVillage {
    private static final class DisjointSet {
        private final int[] roots, rank;

        public DisjointSet(int size) {
            roots = new int[size];
            rank = new int[size];
            for (int i = 0 ; i < size ; i++) {
                roots[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int num) {
            if (num == roots[num]) {
                return num;
            }
            return roots[num] = find(roots[num]);
        }

        public boolean isConnected(int x, int y) {
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

    // Kruskal's algorithm to find MST in unordered weighted graph
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        final List<int[]> edges = new ArrayList<>(pipes.length + n + 1);
        final DisjointSet disjointSet = new DisjointSet(n + 1);

        // add extra vertex and extra edges
        for (int i = 0 ; i < n ; i++) {
            edges.add(new int[] {0, i + 1, wells[i]});
        }

        // add preexisting edges
        edges.addAll(Arrays.asList(pipes));

        // sort edges according to weight
        edges.sort(Comparator.comparingInt(a -> a[2]));

        int totalCost = 0;
        for (int[] edge : edges) {
            final int house1 = edge[0], house2 = edge[1], cost = edge[2];
            if (!disjointSet.isConnected(house1, house2)) {
                disjointSet.union(house1, house2);
                totalCost += cost;
                n--;
                if (n == 0) {
                    break;
                }
            }
        }
        return totalCost;
    }
}
