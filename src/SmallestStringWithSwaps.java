// https://leetcode.com/problems/smallest-string-with-swaps
// s = |s|, p = |pairs|
// T: O(s + p * al(s) + s log(s)) al = inverse Ackermann function
// S: O(s + log(s))

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestStringWithSwaps {
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

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        final DisjointSet disjointSet = new DisjointSet(s.length());
        for (List<Integer> pair : pairs) {
            disjointSet.union(pair.get(0), pair.get(1));
        }
        final Map<Integer, Queue<Character>> charMinHeaps = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++) {
            final int root = disjointSet.find(i);
            final Queue<Character> minHeap = charMinHeaps.getOrDefault(root, new PriorityQueue<>());
            minHeap.add(s.charAt(i));
            charMinHeaps.putIfAbsent(root, minHeap);
        }
        final StringBuilder builder = new StringBuilder();
        for (int i = 0 ; i < s.length() ; i++) {
            final int root = disjointSet.find(i);
            builder.append(charMinHeaps.get(root).poll());
        }
        return builder.toString();
    }
}
