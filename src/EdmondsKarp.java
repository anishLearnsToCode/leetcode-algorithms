import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EdmondsKarp {
    private static int[][] adj_matrix;

    private static int edmonds_karp(int n, int source, int sink) {
        int[] parent = initializeParent(n);
        int max_flow = 0;

        while (bfs(n, source, sink, parent)) {
            int path_flow = Integer.MAX_VALUE;
            int s = sink;
            while (s != source) {
                path_flow = Math.min(path_flow, adj_matrix[parent[s]][s]);
                s = parent[s];
            }
            max_flow += path_flow;

            int v = sink;
            while (v != source) {
                int u = parent[v];
                adj_matrix[u][v] -= path_flow;
                adj_matrix[v][u] += path_flow;
                v = parent[v];
            }

            List<Integer> path = new ArrayList<>();
            v = sink;
            while (v != source) {
                path.add(v);
                v = parent[v];
            }
            path.add(source);
            path = path.reversed();
            System.out.println(path);

            parent = initializeParent(n);
        }

        return max_flow;
    }

    private static int[] initializeParent(int n) {
        final int[] result = new int[n];
        Arrays.fill(result, -1);
        return result;
    }

    private static boolean bfs(int n, int s, int t, int[] parent) {
        final boolean[] visited = new boolean[n];
        final Queue<Integer> queue = new LinkedList<>() {{ add(s); }};
        visited[s] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 0 ; i < n ; i++) {
                final int value = adj_matrix[u][i];
                if (!visited[i] && value > 0) {
                    queue.add(i);
                    visited[i] = true;
                    parent[i] = u;
                }
            }
        }

        return visited[t];
    }
}
