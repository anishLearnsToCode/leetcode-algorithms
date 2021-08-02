from typing import List


class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        moving_sum = sum(nums[i] for i in range(k))
        result = moving_sum
        for i in range(len(nums) - k):
            moving_sum += nums[k + i] - nums[i]
            result = max(result, moving_sum)
        return result / k
