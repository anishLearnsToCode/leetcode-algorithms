// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
// T: O(V + E * alpha(V)) alpha = inverse ackerman function
// S: O(V)

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    private static final class DisjointSet {
        private final int[] root, rank;

        public DisjointSet(int size) {
            root = new int[size];
            rank = new int[size];
            for (int i = 0 ; i < size ; i++) {
                root[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int num) {
            if (num == root[num]) {
                return num;
            }
            return root[num] = find(root[num]);
        }

        public boolean areConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            final int rootX = find(x), rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        final DisjointSet disjointSet = new DisjointSet(n);
        for (int[] edge : edges) {
            if (!disjointSet.areConnected(edge[0], edge[1])) {
                disjointSet.union(edge[0], edge[1]);
                n--;
            }
        }
        return n;
    }
}
