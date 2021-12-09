from typing import List


class Solution:
    def checkIfExist(self, arr: List[int]) -> bool:
        elements = set()
        for number in arr:
            if 2 * number in elements or (number % 2 == 0 and number // 2 in elements):
                return True
            elements.add(number)
        return False
