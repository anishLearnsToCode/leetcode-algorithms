from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        numbers = set()
        for number in nums:
            if number in numbers:
                return True
            numbers.add(number)
        return False
