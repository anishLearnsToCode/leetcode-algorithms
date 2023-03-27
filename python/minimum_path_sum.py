# https://leetcode.com/problems/minimum-path-sum/
# T: O(m*n) where n is the number of rows and m is the number of columns
# S: O(1) 

class Solution:
    def minPathSum(self, grid):
      rows,  columns = len(grid), len(grid[0])

      for column in range(columns - 2, -1, -1):
          grid[rows - 1][column] += grid[rows - 1][column + 1]

      for row in range(rows - 2, -1, -1):
          grid[row][columns - 1] += grid[row + 1][columns - 1]

      for row in range(rows - 2, -1, -1):
          for column in range(columns - 2, -1, -1):
              grid[row][column] += min(grid[row + 1][column], grid[row][column + 1])

      return grid[0][0]
