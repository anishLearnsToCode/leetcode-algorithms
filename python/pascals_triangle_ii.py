from typing import List


class Solution:
    def getRow(self, rowIndex: int) -> List[int]:
        result = [1] * (rowIndex + 1)
        val = 1
        for i in range(1, rowIndex):
            val *= (rowIndex + 1 - i)
            val //= i
            result[i] = val
        return result
