# https://leetcode.com/problems/number-of-operations-to-make-network-connected/description/
# T: O(M) where M is the number of connections
# S: O(N) where N is the number of nodes

class Solution:
    def makeConnected(self, n, connections) -> int:
        if len(connections) < n-1:
            return -1
        if n == 1:
            return 0
        graph = {}
        for a, b in connections:
            if a in graph:
                graph[a].append(b)
            else:
                graph[a] = [b]

            if b in graph:
                graph[b].append(a)
            else:
                graph[b] = [a]

        visited = [0] * n

        def dfs(node):
            if visited[node]:
                return 0
            visited[node] = 1
            if node in graph:
                for num in graph[node]:
                    dfs(num)
            return 1
            

        return sum(dfs(node) for node in range(n)) - 1
