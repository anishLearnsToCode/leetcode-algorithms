from typing import List


class Solution:
    def isOneBitCharacter(self, bits: List[int]) -> bool:
        count = 0
        index = len(bits) - 2
        while index >= 0 and bits[index] != 0:
            if bits[index] == 1: count += 1
            index -= 1
        return count % 2 == 0
