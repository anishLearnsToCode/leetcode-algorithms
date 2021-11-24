from typing import List


class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        leftSum, rightSum = 0, sum(nums)
        index = 0
        while index < len(nums):
            leftSum += nums[index - 1] if index - 1 >= 0 else 0
            rightSum -= nums[index]
            if leftSum == rightSum:
                return index
            index += 1
        return -1
