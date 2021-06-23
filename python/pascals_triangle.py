from typing import List


class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        ans = [None] * numRows
        for i in range(numRows):
            row, mid = [1] * (i + 1), (i >> 1) + 1
            for j in range(1, mid):
                val = ans[i - 1][j - 1] + ans[i-1][j]
                row[j], row[len(row) - j-1] = val, val
            ans[i] = row
        return ans
