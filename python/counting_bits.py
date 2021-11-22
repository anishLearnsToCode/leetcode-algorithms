from typing import List


class Solution:
    def countBits(self, n: int) -> List[int]:
        result = [0] * (n + 1)
        if len(result) > 1: result[1] = 1
        i, k = 0, 2
        while k < len(result):
            i = 0
            while i < k and i + k < len(result):
                result[i + k] = 1 + result[i]
                i += 1
            k *= 2
        return result
