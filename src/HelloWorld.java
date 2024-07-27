import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
kahns algorithm
t: O(V + E)
S: O(E)
 */

public class HelloWorld {
    private static class QuickUnionFind {
        private final int[] array;

        public QuickUnionFind(int size) {
            array = new int[size];
            for (int i = 0 ; i < array.length ; i++) {
                array[i] = i;
            }
        }

        public void union(int x, int y) {
            final int rootX = find(x), rootY = find(y);
            if (rootY == rootX) {
                return;
            }

            for (int i = 0 ; i < array.length ; i++) {
                if (array[i] == rootY) {
                    array[i] = rootX;
                }
            }
        }

        public int find(int num) {
            return array[num];
        }

        public boolean areConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    private static final class QuickUnionDisjointSet {
        private final int[] array;

        public QuickUnionDisjointSet(int size) {
            array = new int[size];
            for (int i = 0 ; i < array.length ; i++) {
                array[i] = i;
            }
        }

        public int find(int num) {
            while (array[num] != num) {
                num = array[num];
            }
            return num;
        }

        public boolean areConnected(int x, int y) {
            return find(x) == find(y);
        }

        public void union(int x, int y) {
            final int rootX = find(x), rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            array[rootY] = rootX;
        }
    }

    private static final class DisjointSetRank {
        private final int[] array;
        private final int[] rank;

        public DisjointSetRank(int size) {
            array = new int[size];
            rank = new int[size];
            for (int i = 0 ; i < array.length ; i++) {
                rank[i] = 1;
                array[i] = i;
            }
        }

        // T: O(logN)
        // S: O(1)
        public int find(int num) {
            if (num == array[num]) {
                return num;
            }
            final int root = find(array[num]);
            array[num] = root;
            return root;
        }

        // T: O(logN)
        // S: O(1)
        public void union(int x, int y) {
            final int rootX = find(x), rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] > rank[rootY]) {
                array[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                array[rootX] = rootY;
            } else {
                array[rootY] = rootX;
                rank[rootX]++;
            }
        }

        // T: O(logN)
        // S: O(1)
        public boolean areConnected(int x, int y) {
            return find(x) == find(y);
        }
    }
}
