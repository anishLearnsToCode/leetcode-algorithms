from typing import List


class Solution:
    def findPoisonedDuration(self, timeSeries: List[int], duration: int) -> int:
        poisonDuration = 0
        index, current = 0, timeSeries[0] - 1
        while index < len(timeSeries):
            poisonDuration += duration - (current - timeSeries[index] + 1)
            current = max(
                timeSeries[index] + duration - 1,
                timeSeries[index + 1] - 1 if index < len(timeSeries) - 1 else 0
            )
            index += 1
        return poisonDuration
