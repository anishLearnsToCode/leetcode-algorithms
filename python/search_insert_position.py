from typing import List


class Solution:
    def searchInsert(self, nums: List[int], target: int) -> int:
        return self.binarySearchNextLargest(nums, target)

    def binarySearchNextLargest(self, array: List[int], val: int) -> int:
        if array is None or len(array) == 0: return 0

        left, right, middle = 0, len(array) - 1, 0
        while left <= right:
            middle = left + (right - left) // 2
            if array[middle] == val: return middle
            elif array[middle] > val: right = middle - 1
            else: left = middle + 1

        return left
