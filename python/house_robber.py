from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        a, b, max_amount = 0, nums[0], nums[0]
        for index in range(1, len(nums)):
            max_amount = max(a + nums[index], b)
            a, b = b, max_amount
        return max_amount
