from typing import List, Tuple


class Solution:
    def dominantIndex(self, nums: List[int]) -> int:
        largest, largestIndex = self.getMax(nums)
        for number in nums:
            if number != largest and 2 * number > largest:
                return -1
        return largestIndex

    def getMax(self, array: List[int]) -> Tuple[int, int]:
        largest, largestIndex = -float('inf'), -1
        for index, element in enumerate(array):
            if element > largest:
                largest = element
                largestIndex = index
        return largest, largestIndex
