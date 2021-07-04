from typing import List


class Solution:
    def findMaxConsecutiveOnes(self, nums: List[int]) -> int:
        max_ones, current = 0, 0
        for number in nums:
            if number == 1:
                current += 1
            else:
                max_ones = max(max_ones, current)
                current = 0
        max_ones = max(max_ones, current)
        return max_ones
