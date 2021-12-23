// https://leetcode.com/problems/find-if-path-exists-in-graph
// T: O(V + E)
// S: O(V + E)

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FindIfPathExistsInGraph {
    public boolean validPath(int n, int[][] edges, int start, int end) {
        UnDirectedGraph graph = UnDirectedGraph.from(n, edges);
        return graph.pathFrom(start, end);
    }

    private static final class UnDirectedGraph {
        private final Map<Integer, Vertex> vertices = new HashMap<>();

        public static UnDirectedGraph from(int vertices, int[][] edges) {
            UnDirectedGraph graph = new UnDirectedGraph(vertices);
            for (int[] edge : edges) {
                graph.vertices.get(edge[0]).addEdge(edge[1]);
                graph.vertices.get(edge[1]).addEdge(edge[0]);
            }
            return graph;
        }

        private UnDirectedGraph(int vertices) {
            for (int i = 0 ; i < vertices ; i++) {
                this.vertices.put(i, new Vertex(i));
            }
        }

        public boolean pathFrom(int start, int end) {
            return pathTo(vertices.get(start), end, new HashSet<>());
        }

        private boolean pathTo(Vertex from, int to, Set<Integer> visited) {
            if (visited.contains(from.value)) return false;
            if (from.value == to) return true;
            visited.add(from.value);
            for (int edge : from.edges) {
                if (pathTo(vertices.get(edge), to, visited)) {
                    return true;
                }
            }
            return false;
        }

        private static final class Vertex {
            private final int value;
            private final Set<Integer> edges = new HashSet<>();

            Vertex(int value) {
                this.value = value;
            }

            public void addEdge(int to) {
                edges.add(to);
            }
        }
    }
}
