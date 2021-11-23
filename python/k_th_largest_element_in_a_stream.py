import heapq
from typing import List


class KthLargest:
    def __init__(self, k: int, nums: List[int]):
        self.heap = []
        self.heap_size = k
        for element in nums:
            heapq.heappush(self.heap, element)
        while len(self.heap) > self.heap_size:
            heapq.heappop(self.heap)

    def add(self, val: int) -> int:
        heapq.heappush(self.heap, val)
        while len(self.heap) > self.heap_size:
            heapq.heappop(self.heap)
        return self.heap[0]
