from typing import List


class Solution:
    def flowerBedCapacity(self, flowerbed: List[int]) -> int:
        capacity = 0
        for index, value in enumerate(flowerbed):
            if value != 1 and (index == 0 or flowerbed[index - 1] == 0) and (index == len(flowerbed) - 1 or flowerbed[index + 1] == 0):
                capacity += 1
                flowerbed[index] = 1
        return capacity

    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        return self.flowerBedCapacity(flowerbed) >= n
