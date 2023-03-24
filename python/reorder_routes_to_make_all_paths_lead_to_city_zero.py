# https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/
# T: O(N) where N is the number of nodes in the graph
# S: O(N) where N is the number of nodes in the graph

class Solution:
    def __init__(self):
        self.reorders = 0

    def minReorder(self, n, connections):
        edges = {(u, v) for u, v in connections}
        graph = {i:[] for i in range(n)}
        for u, v in connections:
            graph[u].append(v)
            graph[v].append(u)
        visit = set()
        visit.add(0)
        def dfs(graph, edges, visit, city):
            for node in graph[city]:
                if node in visit:
                    continue
                if (node, city) not in edges:
                    self.reorders+=1
                visit.add(node)
                dfs(graph, edges, visit, node)
        dfs(graph, edges, visit, 0)
        return self.reorders
