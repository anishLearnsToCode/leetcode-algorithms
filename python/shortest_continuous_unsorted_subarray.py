from typing import List


class Solution:
    def findUnsortedSubarray(self, array: List[int]) -> int:
        l, r, maximum, minimum = len(array), 0, array[0], array[-1]
        for index, value in enumerate(array):
            if value < maximum: r = index + 1
            else: maximum = value
            if array[len(array) - index - 1] > minimum: l = len(array) - 2 - index
            else: minimum = array[len(array) - index - 1]
        return max(0, r - l - 1)
