# https://leetcode.com/problems/reducing-dishes/
#  T: O(nlogn) where n is the length of satisfaction
# S: O(1)

class Solution:
    def maxSatisfaction(self, satisfaction: List[int]) -> int:
        satisfaction.sort(reverse = True)
        n = len(satisfaction)
        presum , res = 0, 0

        for i in range(n):
            presum += satisfaction[i]
            if presum < 0:
                break
            res = res + presum

        return res
