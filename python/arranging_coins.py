import math


class Solution:
    def arrangeCoins(self, n: int) -> int:
        return math.floor((math.sqrt(8 * n + 1) - 1) / 2)
