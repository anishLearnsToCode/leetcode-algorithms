// T: O(N + E alp(N))
// S: O(N)

public class HelloWorld {
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

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        final DisjointSet disjointSet = new DisjointSet(n);
        for (int[] edge : edges) {
            disjointSet.union(edge[0], edge[1]);
        }
        return disjointSet.areConnected(source, destination);
    }
}