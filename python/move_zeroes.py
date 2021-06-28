from typing import List


class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        if len(nums) == 1:
            return
        i, j = 0, 1
        while True:
            while i < len(nums) and nums[i] != 0:
                i += 1
            while j < len(nums) and (nums[j] == 0 or j < i):
                j += 1
            if i >= len(nums) or j >= len(nums):
                break
            nums[i], nums[j] = nums[j], 0
