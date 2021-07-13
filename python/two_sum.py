from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # saving indices in a map for every corresponding number
        positions_map = {}
        for index, number in enumerate(nums):
            positions_map[number] = index

        for index, number in enumerate(nums):
            required = target - number
            if required in positions_map and positions_map[required] != index:
                return [index, positions_map[required]]
