from collections import Counter
from typing import List


class Solution:
    def findLHS(self, array: List[int]) -> int:
        frequencies = Counter(array)
        result = 0
        for value, frequency in frequencies.items():
            result = max(
                result,
                frequencies.get(value - 1) + frequency if value - 1 in frequencies else 0,
                frequencies.get(value + 1) + frequency if value + 1 in frequencies else 0
            )
        return result
