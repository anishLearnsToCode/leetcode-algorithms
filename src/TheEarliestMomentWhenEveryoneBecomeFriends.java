// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends
// M = |logs|
// T: O(N + M logM + M al(N)) al = inverse Ackermann function
// S: O(N + logM)

import java.util.Arrays;
import java.util.Comparator;

public class TheEarliestMomentWhenEveryoneBecomeFriends {
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
            if (rank[rootX] > rank[rootY]) {
                root[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                root[rootX] = rootY;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }

    public int earliestAcq(int[][] logs, int n) {
        final DisjointSet disjointSet = new DisjointSet(n);
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        for (int[] log : logs) {
            if (!disjointSet.areConnected(log[1], log[2])) {
                disjointSet.union(log[1], log[2]);
                n--;
                if (n == 1) {
                    return log[0];
                }
            }
        }
        return -1;
    }
}
