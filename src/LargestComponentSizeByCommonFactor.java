// https://leetcode.com/problems/largest-component-size-by-common-factor
// N = nums, M = max(N)
// T: O(M + N sqrt(M) al(M) + N al(N)) al = inverse Ackermann function
// S: O(M + N)

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestComponentSizeByCommonFactor {
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
                root[rootY] = rootX;
            } else {
                root[rootY] = rootX;
                rank[rootX]++;
            }
        }

        public int size() {
            return root.length;
        }
    }

    public int largestComponentSize(int[] nums) {
        final int maxValue = Arrays.stream(nums).max().getAsInt();
        final DisjointSet disjointSet = new DisjointSet(maxValue + 1);
        for (int number : nums) {
            for (int i = 2 ; i * i <= number ; i++) {
                if (number % i == 0) {
                    disjointSet.union(number, i);
                    disjointSet.union(number, number/ i);
                }
            }
        }
        return largestComponentSize(disjointSet, nums);
    }

    private static int largestComponentSize(DisjointSet disjointSet, int[] numbers) {
        final Map<Integer, Integer> rootFrequencies = new HashMap<>();
        int maxSize = 1;
        for (int number : numbers) {
            final int root = disjointSet.find(number);
            rootFrequencies.put(root, rootFrequencies.getOrDefault(root, 0) + 1);
            maxSize = Math.max(maxSize, rootFrequencies.get(root));
        }
        return maxSize;
    }
}
