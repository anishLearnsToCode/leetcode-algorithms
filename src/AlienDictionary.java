// https://leetcode.com/problems/alien-dictionary
// T: O()
// S: O()

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        final Map<Character, Set<Character>> graph = createGraphFrom(words);
        return lexicographicallySmallest(graph);
    }

    private static String lexicographicallySmallest(Map<Character, Set<Character>> graph) {
        final Map<Character, Integer> inDegree = computeInDegree(graph);
        final Queue<Character> queue = new LinkedList<>();
        final StringBuilder builder = new StringBuilder();
        add0InDegreeInQueue(queue, inDegree);

        while (!queue.isEmpty()) {
            final char c = queue.poll();
            builder.append(c);
            for (char neighbour : graph.getOrDefault(c, new HashSet<>())) {
                inDegree.put(neighbour, inDegree.get(neighbour) - 1);
                if (inDegree.get(neighbour) == 0) {
                    queue.add(neighbour);
                }
            }
            graph.remove(c);
        }

        if (graph.isEmpty()) {
            return builder.toString();
        }
        return "";
    }

    private static Map<Character, Set<Character>> createGraphFrom(String[] words) {
        final Map<Character, Set<Character>> graph = new HashMap<>();
        addAllLettersInGraph(graph, words);
        for (int i = 0 ; i < words.length ; i++) {
            for (int j = i + 1 ; j < words.length ; j++) {
                if (words[i].equals(words[j])) {
                    continue;
                }
                final char[] charDiff = firstDifferentCharacter(words[i], words[j]);
                if (charDiff.length == 0) {
                    continue;
                }
                final Set<Character> set = graph.getOrDefault(charDiff[0], new HashSet<>());
                set.add(charDiff[1]);
                graph.putIfAbsent(charDiff[0], set);
            }
        }
        return graph;
    }

    private static void addAllLettersInGraph(Map<Character, Set<Character>> graph, String[] words) {
        for (String word : words) {
            for (int i = 0 ; i < word.length() ; i++) {
                graph.putIfAbsent(word.charAt(i), new HashSet<>());
            }
        }
    }

    private static char[] firstDifferentCharacter(String s1, String s2) {
        for (int i = 0 ; i < s1.length() && i < s2.length() ; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return new char[] { s1.charAt(i), s2.charAt(i) };
            }
        }
        return new char[] {};
    }

    private static Map<Character, Integer> computeInDegree(Map<Character, Set<Character>> graph) {
        final Map<Character, Integer> inDegree = new HashMap<>();
        for (Set<Character> set : graph.values()) {
            for (char c : set) {
                inDegree.put(c, inDegree.getOrDefault(c, 0) + 1);
            }
        }
        return inDegree;
    }

    private static void add0InDegreeInQueue(Queue<Character> queue, Map<Character, Integer> inDegree) {
        for (Map.Entry<Character, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }
    }
}
