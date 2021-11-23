from typing import List


class Solution:
    def search(self, array: List[int], target: int) -> int:
        left, right = 0, len(array) - 1
        while left <= right:
            middle = left + (right - left) // 2
            if array[middle] == target: return middle
            elif array[middle] > target: right = middle - 1
            else: left = middle + 1
        return -1
