from typing import List


class Solution:
    def imageSmoother(self, img: List[List[int]]) -> List[List[int]]:
        rows, columns = len(img), len(img[0])
        result = [[0 for i in range(columns)] for j in range(rows)]
        for row in range(rows):
            for column in range(columns):
                k_sum, count = 0, 0
                for k_row in range(row if row == 0 else row - 1, (row if row == rows - 1 else row + 1) + 1):
                    for k_column in range(column if column == 0 else column - 1, (column if column == columns - 1 else column + 1) + 1):
                        k_sum += img[k_row][k_column]
                        count += 1
                result[row][column] = k_sum // count
        return result
