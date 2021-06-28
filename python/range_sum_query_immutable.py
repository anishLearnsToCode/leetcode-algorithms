from typing import List


class NumArray:

    def __init__(self, nums: List[int]):
        self.sum_till = [0] * (len(nums) + 1)
        for index, number in enumerate(nums):
            self.sum_till[index + 1] = self.sum_till[index] + number

    def sumRange(self, left: int, right: int) -> int:
        return self.sum_till[right + 1] - self.sum_till[left]
