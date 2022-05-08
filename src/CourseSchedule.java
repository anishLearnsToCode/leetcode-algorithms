// https://leetcode.com/problems/course-schedule
// T: O(|pre-requisites| + numCourses)
// S: O(numCourses)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        final int[] inDegree = getInDegreeValues(prerequisites, numCourses);
        final Queue<Integer> queue = queueWithInDegree0Vertices(inDegree);
        final Map<Integer, List<Integer>> graph = getDependencyGraph(prerequisites);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (graph.containsKey(vertex)) {
                for (int adjacent : graph.get(vertex)) {
                    inDegree[adjacent]--;
                    if (inDegree[adjacent] == 0) queue.add(adjacent);
                }
            }
        }

        return allAreZero(inDegree);
    }

    private boolean allAreZero(int[] array) {
        for (int element : array) {
            if (element != 0) return false;
        }
        return true;
    }

    private Queue<Integer> queueWithInDegree0Vertices(int[] inDegrees) {
        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                queue.add(i);
            }
        }
        return queue;
    }

    private static int[] getInDegreeValues(int[][] preRequisites, int numCourses) {
        int[] result = new int[numCourses];
        for (int[] preRequisite: preRequisites) {
            result[preRequisite[1]]++;
        }
        return result;
    }

    private static Map<Integer, List<Integer>> getDependencyGraph(int[][] prerequisites) {
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
