from collections import Counter
from typing import List, Dict


class Solution:
    def getLeftPosition(self, array: List[int]) -> Dict[int, int]:
        positions = {}
        for index, element in enumerate(array):
            if element not in positions:
                positions[element] = index
        return positions

    def getRightPosition(self, array: List[int]) -> Dict[int, int]:
        return {number : index for index, number in enumerate(array)}

    def findShortestSubArray(self, numbers: List[int]) -> int:
        frequencies = Counter(numbers)
        leftMost = self.getLeftPosition(numbers)
        rightMost = self.getRightPosition(numbers)
        maxFrequency = max(frequencies.values())
        result = float('inf')
        for number, frequency in frequencies.items():
            if frequency == maxFrequency:
                result = min(result, rightMost[number] - leftMost[number] + 1)
        return result
