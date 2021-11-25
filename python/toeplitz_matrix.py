from typing import List


class Solution:
    def isToeplitzMatrix(self, matrix: List[List[int]]) -> bool:
        columns, rows = len(matrix[0]), len(matrix)
        for column in range(columns - 1):
            current = matrix[0][column]
            for row in range(1, rows):
                if column + row >= columns:
                    break
                if matrix[row][column + row] != current:
                    return False
        for row in range(1, rows - 1):
            current = matrix[row][0]
            for column in range(1, columns):
                if row + column >= rows:
                    break
                if matrix[row + column][column] != current:
                    return False
        return True
