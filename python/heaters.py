from typing import List


class Solution:
    def binary_search(self, array: List[int], element: int) -> int:
        left, right = 0, len(array) - 1
        while left <= right:
            middle = (left + right) // 2
            if array[middle] == element: return middle
            elif array[middle] < element: left = middle + 1
            else: right = middle - 1
        return left

    def findRadius(self, houses: List[int], heaters: List[int]) -> int:
        heaters.sort()
        minRadius, infinity = 0, float('inf')
        for house in houses:
            index = self.binary_search(heaters, house)
            if index < len(heaters) and house == heaters[index]:
                continue
            leftRadius = infinity if index == 0 else house - heaters[index - 1]
            rightRadius = infinity if index == len(heaters) else heaters[index] - house
            minRadius = max(minRadius, min(leftRadius, rightRadius))
        return minRadius
