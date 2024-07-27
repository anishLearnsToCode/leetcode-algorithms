// https://leetcode.com/problems/redundant-connection
// T: O(N)
// S: O(N)

public class RedundantConnection {
    private static final class DisjointSet {
        private final int[] root, rank;

        public DisjointSet(int size) {
            this.root = new int[size];
            this.rank = new int[size];
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
                root[rootY] = rootX;
            } else if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        final DisjointSet disjointSet = new DisjointSet(edges.length);
        for (int[] edge : edges) {
            if (disjointSet.areConnected(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
            disjointSet.union(edge[0] - 1, edge[1] - 1);
        }
        return new int[] {};
    }
}
