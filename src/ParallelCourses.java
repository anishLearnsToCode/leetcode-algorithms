// https://leetcode.com/problems/parallel-courses
// T: O(N + E)
// S: O(N + E)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        final Map<Integer, Set<Integer>> graph = createGraph(relations);
        final int[] inDegree = computeInDegree(relations, n);
        return minimumSemesters(graph, inDegree);
    }

    // Kahn's algorithm T: O(N + E), S: O(N)
    private static int minimumSemesters(Map<Integer, Set<Integer>> graph, int[] inDegree) {
        Set<Integer> noPrerequisites = coursesWithoutPrerequisites(inDegree);
        int minSemesters = 0;

        while (!noPrerequisites.isEmpty()) {
            final Set<Integer> newCourses = new HashSet<>();
            for (int course : noPrerequisites) {
                inDegree[course]--;
                for (int neighbour : graph.getOrDefault(course, new HashSet<>())) {
                    inDegree[neighbour]--;
                    if (inDegree[neighbour] == 0) {
                        newCourses.add(neighbour);
                    }
                }
                graph.remove(course);
            }
            noPrerequisites = newCourses;
            minSemesters++;
        }

        return graph.isEmpty() ? minSemesters : -1;
    }

    // T: O(E), S: O(N)
    private static int[] computeInDegree(int[][] edges, int n) {
        final int[] inDegree = new int[n];
        for (int[] edge : edges) {
            final int to = edge[1] - 1;
            inDegree[to]++;
        }
        return inDegree;
    }

    // T: O(N), S: O(N)
    private static Set<Integer> coursesWithoutPrerequisites(int[] inDegree) {
        final Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < inDegree.length ; i++) {
            if (inDegree[i] == 0) {
                set.add(i);
            }
        }
        return set;
    }

    // T: O(E), S: O(E)
    private static Map<Integer, Set<Integer>> createGraph(int[][] edges) {
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            final int from = edge[0] - 1, to = edge[1] - 1;
            final Set<Integer> fromNeighbours = graph.getOrDefault(from, new HashSet<>());
            fromNeighbours.add(to);
            graph.putIfAbsent(from, fromNeighbours);
        }
        return graph;
    }
}
