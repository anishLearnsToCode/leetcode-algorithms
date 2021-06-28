from typing import List


class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        n = len(nums)
        acttual_sum = (n * (n + 1)) // 2
        return acttual_sum - sum(nums)
