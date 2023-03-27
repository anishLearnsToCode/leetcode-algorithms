# https://leetcode.com/problems/longest-cycle-in-a-graph/description/
# T:O(N) where N is the number of nodes in the graph
# S:O(N) where N is the number of nodes in the graph

class Solution:
    def __init__(self):
        self.answer = -1
    
    def dfs(self, node, edges, dist, visit):
        visit[node] = True
        neighbor = edges[node]
        
        if neighbor != -1 and not visit[neighbor]:
            dist[neighbor] = dist[node] + 1
            self.dfs(neighbor, edges, dist, visit)
        elif neighbor != -1 and neighbor in dist:
            self.answer = max(self.answer, dist[node] - dist[neighbor] + 1)
    
    def longestCycle(self, edges):
        n = len(edges)
        visit = [False] * n
        
        for i in range(n):
            if not visit[i]:
                dist = {i: 1}
                self.dfs(i, edges, dist, visit)
        
        return self.answer
