from typing import List


class Solution:
    def removeDuplicates(self, array: List[int]) -> int:
        if len(array) == 0:
            return 0

        position = 1
        previouslyEncountered = array[0]
        for index in range(1, len(array)):
            if array[index] != previouslyEncountered:
                array[position] = array[index]
                position += 1
                previouslyEncountered = array[index]

        return position
