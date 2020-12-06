from typing import List


class Solution:
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        s.sort()
        g.sort()
        i = 0
        contendedChildren = 0
        for j in range(len(s)):
            if i < len(g) and s[j] >= g[i]:
                contendedChildren += 1
                i += 1
        return contendedChildren
