from typing import List


class Solution:
    def findLengthOfLCIS(self, nums: List[int]) -> int:
        current, result = 1, 1
        for index in range(1, len(nums)):
            if nums[index] > nums[index - 1]:
                current += 1
                result = max(result, current)
            else:
                current = 1
        return result
