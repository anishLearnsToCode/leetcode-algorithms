# https://leetcode.com/problems/number-of-enclaves/description/
# T: O(m*n) 
# S: O(m*n) 

from typing import List

class Solution:
    def dfs(self, x: int, y: int, m: int, n: int, grid: List[List[int]], visit: List[List[bool]]):
        if x < 0 or x >= m or y < 0 or y >= n or visit[x][y] or grid[x][y] == 0:
            return
        visit[x][y] = True
        self.dfs(x+1, y, m, n, grid, visit)
        self.dfs(x-1, y, m, n, grid, visit)
        self.dfs(x, y+1, m, n, grid, visit)
        self.dfs(x, y-1, m, n, grid, visit)

    def numEnclaves(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        visit = [[False for _ in range(n)] for _ in range(m)]

        # Traverse the first and last columns.
        for i in range(m):
            if grid[i][0] == 1 and not visit[i][0]:
                self.dfs(i, 0, m, n, grid, visit)
            if grid[i][n-1] == 1 and not visit[i][n-1]:
                self.dfs(i, n-1, m, n, grid, visit)

        # Traverse the first and last rows.
        for j in range(n):
            if grid[0][j] == 1 and not visit[0][j]:
                self.dfs(0, j, m, n, grid, visit)
            if grid[m-1][j] == 1 and not visit[m-1][j]:
                self.dfs(m-1, j, m, n, grid, visit)

        # Count the number of unvisited land cells.
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1 and not visit[i][j]:
                    count += 1

        return count
