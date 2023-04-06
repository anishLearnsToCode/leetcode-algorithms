# https://leetcode.com/problems/number-of-closed-islands/description/
# T: O(m*n) 
# S: O(m*n) 

class Solution:
    def closedIsland(self, grid: List[List[int]]) -> int:
        m = len(grid)
        n = len(grid[0])
        visit = [[False] * n for _ in range(m)]
        count = 0

        def dfs(x: int, y: int, m: int, n: int, grid: List[List[int]], visit: List[List[bool]]) -> bool:
            if x < 0 or x >= m or y < 0 or y >= n:
                # (x, y) is a boundary cell.
                return False
            if grid[x][y] == 1 or visit[x][y]:
                # (x, y) is not a valid cell to visit.
                return True
            visit[x][y] = True
            isClosed = True
            for dx, dy in [(0, 1), (1, 0), (0, -1), (-1, 0)]:
                isClosed &= dfs(x + dx, y + dy, m, n, grid, visit)
            return isClosed

        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0 and not visit[i][j] and dfs(i, j, m, n, grid, visit):
                    count += 1

        return count
