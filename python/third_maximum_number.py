from typing import List
import heapq


class Solution:
    def thirdMax(self, nums: List[int]) -> int:
        distinct = set(nums)
        if len(distinct) < 3:
            return max(distinct)
        heap = []
        for number in distinct:
            heapq.heappush(heap, -number)
        heapq.heappop(heap)
        heapq.heappop(heap)
        return heapq.heappop(heap)
