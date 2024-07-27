// https://leetcode.com/problems/number-of-provinces
// T: O(N^2)
// S: O(N)

public class NumberOfProvinces {
    private static final class DisjointSet {
        private final int[] array, rank;

        public DisjointSet(int size) {
            this.array = new int[size];
            this.rank = new int[size];
            for (int i = 0 ; i < size ; i++) {
                array[i] = i;
                rank[i] = 1;
            }
        }

        // T: O(1)
        public int find(int x) {
            if (x == array[x]) {
                return x;
            }
            final int rank = find(array[x]);
            array[x] = rank;
            return rank;
        }

        // T: O(1)
        public boolean areConnected(int x, int y) {
            return find(x) == find(y);
        }

        // T: O(1)
        public void union(int x, int y) {
            final int rootX = find(x), rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (array[rootX] > array[rootY]) {
                array[rootY] = rootX;
            } else if (array[rootX] < array[rootY]) {
                array[rootX] = rootY;
            } else {
                array[rootY] = rootX;
                rank[rootX]++;
            }
        }

        private int size() {
            return array.length;
        }
    }

    // T: O(n^2)
    public int findCircleNum(int[][] isConnected) {
        final int cities = isConnected.length;
        final DisjointSet disjointSet = new DisjointSet(cities);
        int provinces = cities;

        for (int i = 0 ; i < cities ; i++) {
            for (int j = i + 1 ; j < cities ; j++) {
                if (isConnected[i][j] == 1 && disjointSet.find(i) != disjointSet.find(j)) {
                    disjointSet.union(i, j);
                    provinces--;
                }
            }
        }

        return provinces;
    }
}
