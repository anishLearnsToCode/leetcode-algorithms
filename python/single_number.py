from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        val = 0
        for number in nums:
            val ^= number
        return val
