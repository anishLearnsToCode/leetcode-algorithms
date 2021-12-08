from typing import List


class Solution:
    def replaceElements(self, array: List[int]) -> List[int]:
        result = [0] * len(array)
        result[len(result) - 1] = -1
        index, greatest = len(array) - 2, array[len(array) - 1]
        while index >= 0:
            result[index] = greatest
            greatest = max(greatest, array[index])
            index -= 1
        return result
