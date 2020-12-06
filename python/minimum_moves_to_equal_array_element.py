from typing import List


class Solution:
    def minMoves(self, nums: List[int]) -> int:
        minValue = min(nums)
        return sum(nums) - minValue * len(nums)
