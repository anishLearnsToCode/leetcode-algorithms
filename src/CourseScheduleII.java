// https://leetcode.com/problems/course-schedule-ii
// T: O(V + E) --> O(numCourses + |preReq|)
// S: O(V + E) --> O(numCourses + |preReq|)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {
    private static final class Vertex {
        private final int data;
        private final Set<Edge> edges = new HashSet<>();
        private int outDegree = 0;

        Vertex(int data) {
            this.data = data;
        }

        private void addEdge(Edge edge) {
            edges.add(edge);
            if (edge.from == this) outDegree++;
        }

        private void removeEdge(Edge edge) {
            edges.remove(edge);
            if (edge.from == this) outDegree--;
        }

        private boolean hasDependency() {
            return outDegree > 0;
        }
    }

    private record Edge(Vertex from, Vertex to) { }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final Map<Integer, Vertex> graph = createGraphWithNVertices(numCourses);
        mapPrerequisitesInGraph(graph, prerequisites);
        List<Integer> topologicalOrder = topologicalSort(graph);
        return topologicalOrder.size() == numCourses ? toArray(topologicalOrder) : new int[] { };
    }

    private List<Integer> topologicalSort(Map<Integer, Vertex> graph) {
        final Queue<Vertex> queue = zeroDependencyVertices(graph);
        final List<Integer> order = new ArrayList<>();

        while (!queue.isEmpty()) {
            Vertex vertex = queue.poll();
            order.add(vertex.data);
            for (Edge edge : vertex.edges) {
                edge.from.removeEdge(edge);
                if (!edge.from.hasDependency()) {
                    queue.add(edge.from);
                }
            }
        }

        return order;
    }

    private Queue<Vertex> zeroDependencyVertices(Map<Integer, Vertex> graph) {
        final Queue<Vertex> queue = new LinkedList<>();
        for (Vertex vertex : graph.values()) {
            if (!vertex.hasDependency()) {
                queue.add(vertex);
            }
        }
        return queue;
    }

    private void mapPrerequisitesInGraph(Map<Integer, Vertex> graph, int[][] prerequisites) {
        for (int[] preRequisite : prerequisites) {
            Vertex from = graph.get(preRequisite[0]);
            Vertex to = graph.get(preRequisite[1]);
            Edge edge = new Edge(from, to);
            from.addEdge(edge);
            to.addEdge(edge);
        }
    }

    private Map<Integer, Vertex> createGraphWithNVertices(int n) {
        final Map<Integer, Vertex> graph = new HashMap<>();
        for (int i = 0 ; i < n ; i++) {
            graph.put(i, new Vertex(i));
        }
        return graph;
    }

    private int[] toArray(List<Integer> list) {
        final int[] array = new int[list.size()];
        for (int i = 0 ; i < array.length ; i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}
