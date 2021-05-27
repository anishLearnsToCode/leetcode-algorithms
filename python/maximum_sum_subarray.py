# Kadane's Algorithm
from typing import List


class Solution:
    def maxSubArray(self, array: List[int]) -> int:
        max_sum, current_sum = -float('infinity'), 0
        for element in array:
            current_sum += element
            max_sum = max(current_sum, max_sum)
            current_sum = max(current_sum, 0)
        return int(max_sum)
