# https://leetcode.com/problems/successful-pairs-of-spells-and-potions/editorial/
#  T: O((n + m)logm) where n is the number of spells and m is the number of potions
#  S: O(m) where m is the number of potions

class Solution:
    def successfulPairs(self, spells: List[int], potions: List[int], success: int) -> List[int]:
        potions.sort()
        return [len(potions) - bisect_left(potions, (success + x - 1) // x) for x in spells]
