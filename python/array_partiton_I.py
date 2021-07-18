from typing import List


class Solution:
    def arrayPairSum(self, nums: List[int]) -> int:
        nums.sort()
        result = 0
        for i in range(0, len(nums) // 2):
            result += min(nums[2 * i], nums[2 * i + 1])
        return result
