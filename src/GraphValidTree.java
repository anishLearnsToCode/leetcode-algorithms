// https://leetcode.com/problems/graph-valid-tree
// T: O(N)
// S: O(N)

public class GraphValidTree {
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
            if (root[num] == num) {
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
            if (root[rootX] < root[rootY]) {
                root[rootX] = rootY;
            } else if (root[rootX] > root[rootY]) {
                root[rootY] = rootX;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        final DisjointSet disjointSet = new DisjointSet(n);
        for (int[] edge : edges) {
            if (disjointSet.areConnected(edge[0], edge[1])) {
                return false;
            }
            disjointSet.union(edge[0], edge[1]);
        }
        return true;
    }
}
