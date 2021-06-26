from typing import List


class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        position = {}
        for index, number in enumerate(nums):
            if number in position and abs(index - position[number]) <= k:
                return True
            position[number] = index
        return False
