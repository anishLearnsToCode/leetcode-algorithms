// https://leetcode.com/problems/minimum-genetic-mutation
// T: O(B)
// S: O(1)

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinimumGeneticMutation {
    private record Info(String mutation, int steps) {}

    private static final char[] GENES = new char[] {'A', 'G', 'C', 'T'};

    // n = length of string (8), m = possible number of characters
    // BFS, T: O(V + E) = O(nB + n^m * mn) S: O(n^m)
    public static int minMutation(String startGene, String endGene, String[] bank) {
        final Set<String> genePool = toSet(bank);
        if (!genePool.contains(endGene)) {
            return -1;
        }

        final Queue<Info> queue = new LinkedList<>() {{ add(new Info(startGene, 0)); }};
        final Map<String, Integer> distances = new HashMap<>();

        while (!queue.isEmpty()) {
            final Info info = queue.poll();
            if (distances.getOrDefault(info.mutation, Integer.MAX_VALUE) <= info.steps) {
                continue;
            }
            distances.put(info.mutation, info.steps);

            for (String neighbour : validMutations(genePool, info.mutation)) {
                queue.add(new Info(neighbour, info.steps + 1));
            }
        }

        return distances.getOrDefault(endGene, -1);
    }

    // T: O(|s|), S: O(|s|)
    private static List<String> validMutations(Set<String> genePool, String s) {
        final List<String> result = new ArrayList<>();
        for (int i = 0 ; i < s.length() ; i++) {
            for (char c : GENES) {
                final String mutation = s.substring(0, i) + c + s.substring(i + 1);
                if (genePool.contains(mutation)) {
                    result.add(mutation);
                }
            }
        }
        return result;
    }

    // T: O(nB) S: O(nB)
    private static Set<String> toSet(String[] bank) {
        final Set<String> set = new HashSet<>();
        Collections.addAll(set, bank);
        return set;
    }
}
