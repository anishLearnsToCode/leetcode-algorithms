from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # saving indices in a map for every corresponding number
        positions_map = {}
        for index, number in enumerate(nums):
            positions = positions_map.get(number, [])
            positions.append(index)
            positions_map[number] = positions

        for index, number in enumerate(nums):
            required = target - number
            if required in positions_map:
                positions = positions_map[required]
                for i in positions:
                    if i != index:
                        return [index, i]
