import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class HelloWorld {
    // T: O(V + E) S: O(V + E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        final Map<Integer, Set<Integer>> graph = createGraph(prerequisites);
        final int[] inDegree = computeInDegree(numCourses, prerequisites);
        return orderOfCourses(graph, inDegree);
    }

    // T: O(V + E) S: O(V)
    private static int[] orderOfCourses(Map<Integer, Set<Integer>> graph, int[] inDegree) {
        final Queue<Integer> queue = new PriorityQueue<>();
        final List<Integer> order = new ArrayList<>();
        addAll0InDegreeToQueue(queue, inDegree);

        while (!queue.isEmpty()) {
            final int vertex = queue.poll();
            order.add(vertex);
            for (int neighbour : graph.getOrDefault(vertex, new HashSet<>())) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
            graph.remove(vertex);
        }

        if (order.size() != inDegree.length) {
            return new int[] {};
        }
        return toArray(order);
    }

    private static int[] toArray(List<Integer> list) {
        final int[] array = new int[list.size()];
        for (int i = 0 ; i < array.length ; i++) {
            array[i] = list.get(i);
        }
        return array;
    }

    // T: O(E) S: O(1)
    private static void addAll0InDegreeToQueue(Queue<Integer> queue, int[] inDegree) {
        for (int i = 0 ; i < inDegree.length ; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
    }

    // T: O(E) S: O(E)
    private static int[] computeInDegree(int n, int[][] edges) {
        final int[] inDegree = new int[n];
        for (int[] edge : edges) {
            final int to = edge[0];
            inDegree[to]++;
        }
        return inDegree;
    }

    // T: O(|E|), S: O(E)
    private static Map<Integer, Set<Integer>> createGraph(int[][] edges) {
        final Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            final int to = edge[0], from = edge[1];
            final Set<Integer> set = graph.getOrDefault(from, new HashSet<>());
            set.add(to);
            graph.putIfAbsent(from, set);
        }
        return graph;
    }
}