# https://leetcode.com/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/
# T: O(N + E) where N is the number of nodes and E is the number of edges
# S: O(N + E) where N is the number of nodes and E is the number of edges

from collections import defaultdict
class Solution:
    def __init__(self):
        self.graph = defaultdict(list)
        self.visited = set()
        self.n = 0

    def add_edge(self, u, v):
        self.graph[u].append(v)
        self.graph[v].append(u)

    def dfs(self, v, component):
        self.visited.add(v)
        component.append(v)
        for neighbor in self.graph[v]:
            if neighbor not in self.visited:
                self.dfs(neighbor, component)

    def find_components(self):
        components = []
        for v in range(self.n):
            if v not in self.visited:
                component = []
                self.dfs(v, component)
                components.append(component)

        return components

    def countPairs(self, n, edges):
        for u, v in edges:
            self.add_edge(u, v)
        self.n = n
        component_lengths = []
        components = self.find_components()
        for component in components:
            component_lengths.append(len(component))
        print(components, component_lengths)

        k = sum(component_lengths)
        sol = 0
        for l in component_lengths:
            sol+=((k-l)*l)
        sol = sol//2

        return sol
