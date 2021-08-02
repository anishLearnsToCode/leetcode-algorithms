from typing import List


class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        repeated, missing = 0, 0
        for number in nums:
            if nums[abs(number) - 1] < 0: repeated = number
            else: nums[abs(number) - 1] *= -1
        for index in range(len(nums)):
            if nums[index] > 0:
                missing = index + 1
                break
        return [abs(repeated), missing]
