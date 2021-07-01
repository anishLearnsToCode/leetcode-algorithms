from typing import List


class Solution:
    def findDisappearedNumbers(self, nums: List[int]) -> List[int]:
        numbers = set(nums)
        result = []
        for number in range(1, len(nums) + 1):
            if number not in numbers:
                result.append(number)
        return result
