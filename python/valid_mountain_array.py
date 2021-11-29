from typing import List


class Solution:
    def validMountainArray(self, numbers: List[int]) -> bool:
        isIncreasing = True
        index = 1
        while index < len(numbers):
            if numbers[index] == numbers[index - 1]: return False
            if numbers[index] < numbers[index - 1] and isIncreasing:
                if index == 1: return False
                isIncreasing = False
            if numbers[index] > numbers[index - 1] and not isIncreasing:
                return False
            index += 1
        return not isIncreasing
