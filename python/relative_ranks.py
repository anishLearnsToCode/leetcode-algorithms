from typing import List


class Solution:
    def get_rank(self, position: int) -> str:
        if position == 1: return 'Gold Medal'
        if position == 2: return 'Silver Medal'
        if position == 3: return 'Bronze Medal'
        return str(position)

    def findRelativeRanks(self, score: List[int]) -> List[str]:
        numbers = [(index, val) for index, val in enumerate(score)]
        numbers.sort(key=lambda x: x[1], reverse=True)
        value_to_index = {}
        for index, (_, value) in enumerate(numbers):
            value_to_index[value] = index
        result = [''] * len(score)
        for index, value in enumerate(score):
            result[index] = self.get_rank(value_to_index[value] + 1)
        return result
