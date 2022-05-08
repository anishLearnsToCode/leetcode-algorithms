// https://leetcode.com/problems/course-schedule
// T: O(|pre-requisites| + numCourses)
// S: O(numCourses)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final Map<Integer, List<Integer>> dependencyGraph = getDependencyGraph(prerequisites);
        return !containsLoop(dependencyGraph, numCourses);
    }

    private boolean containsLoop(Map<Integer, List<Integer>> graph, int numCourses) {
        Set<Integer> computed = new HashSet<>();
        for (int i = 0 ; i < numCourses ; i++) {
            if (graph.containsKey(i)) {
                if (computed.contains(i)) continue;
                if (containsLoop(graph, i, computed)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsLoop(Map<Integer, List<Integer>> graph, int vertex, Set<Integer> computed) {
        return containsLoop(graph, vertex, computed, new HashSet<>());
    }

    private boolean containsLoop(Map<Integer, List<Integer>> graph, int vertex, Set<Integer> computed, Set<Integer> visited) {
        if (visited.contains(vertex)) return true;
        if (computed.contains(vertex)) return false;
        visited.add(vertex);
        computed.add(vertex);
        if (graph.containsKey(vertex)) {
            List<Integer> dependsOn = graph.get(vertex);
            for (int dependency : dependsOn) {
                if (containsLoop(graph, dependency, computed, visited)) {
                    return true;
                }
            }
        }
        visited.remove(vertex);
        return false;
    }

    private Map<Integer, List<Integer>> getDependencyGraph(int[][] prerequisites) {
        final Map<Integer, List<Integer>> dependencyGraph = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!dependencyGraph.containsKey(prerequisite[0])) {
                dependencyGraph.put(prerequisite[0], new ArrayList<>());
            }
            dependencyGraph.get(prerequisite[0]).add(prerequisite[1]);
        }
        return dependencyGraph;
    }
}
