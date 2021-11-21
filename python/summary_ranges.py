from typing import List


class Solution:
    def getRangeString(self, start: int, end: int) -> str:
        return f'{start}' if start == end else f'{start}->{end}'

    def summaryRanges(self, array: List[int]) -> List[str]:
        if len(array) == 0: return []
        result = []
        startIndex, index = 0, 1
        while index < len(array):
            if array[index] > array[startIndex] + (index - startIndex):
                result.append(self.getRangeString(array[startIndex], array[index - 1]))
                startIndex = index
            index += 1
        result.append(self.getRangeString(array[startIndex], array[len(array) - 1]))
        return result
