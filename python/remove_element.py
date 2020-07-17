from typing import List


class Solution:
    def removeElement(self, array: List[int], val: int) -> int:
        position = 0
        for element in array:
            if element is val:
                continue
            array[position] = element
            position += 1

        return position
