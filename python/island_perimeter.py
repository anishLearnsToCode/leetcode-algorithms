from typing import List


class Solution:
    def islandPerimeter(self, grid: List[List[int]]) -> int:
        perimeter, rows, columns = 0, len(grid), len(grid[0])
        for row in range(rows):
            for column in range(columns):
                if grid[row][column] == 1:
                    perimeter += 4 - self.surroundedBy(grid, row, column)
        return perimeter

    def surroundedBy(self, grid: List[List[int]], row: int, column: int) -> int:
        surrounded = 0
        if row - 1 >= 0 and grid[row - 1][column] == 1:
            surrounded += 1
        if column + 1 < len(grid[0]) and grid[row][column + 1] == 1:
            surrounded += 1
        if row + 1 < len(grid) and grid[row + 1][column] == 1:
            surrounded += 1
        if column - 1 >= 0 and grid[row][column - 1] == 1:
            surrounded += 1
        return surrounded
