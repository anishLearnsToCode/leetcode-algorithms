from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        element, count = nums[0], 0
        for number in nums:
            count += 1 if number == element else -1
            if count == 0:
                element = number
                count = 1
        return element
