from typing import List


class Solution:
    def checkPossibility(self, nums: List[int]) -> bool:
        handled_decreasing = False
        for index in range(len(nums) - 1):
            if nums[index] > nums[index + 1]:
                if handled_decreasing: return False
                handled_decreasing = True
                if index - 1 >= 0 and nums[index - 1] > nums[index + 1] and index + 2 < len(nums) and nums[index] > nums[index + 2]:
                    return False
        return True
