# https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/
# T: O(N + M) where N is the number of nodes and M is the number of edges
# S: O(N + M) where N is the number of nodes and M is the number of edges

from collections import deque

class Solution:
    def __init__(self):
        self.min_dist = 1e14

    def minScore(self, n: int, roads) -> int:
        graph = {}
        vis = [False]*n
        for x, y, d in roads:
            if x in graph:
                graph[x].append((y, d))
            else:
                graph[x] = [(y, d)]
            if y in graph:
                graph[y].append((x, d))
            else:
                graph[y] = [(x, d)]

        visited = set()
        queue = deque([1])

        while queue:
            node = queue.popleft()
            for adj, score in graph[node]:
                if adj not in visited:
                    queue.append(adj)
                    visited.add(adj)
                self.min_dist = min(self.min_dist, score)
        return self.min_dist
