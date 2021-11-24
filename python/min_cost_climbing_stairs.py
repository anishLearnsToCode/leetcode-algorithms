from typing import List


class Solution:
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        previousCost, currentCost = cost[0], cost[1]
        index = 2
        while index < len(cost):
            previousCost, currentCost = currentCost, min(previousCost, currentCost) + cost[index]
            index += 1
        return min(previousCost, currentCost)
