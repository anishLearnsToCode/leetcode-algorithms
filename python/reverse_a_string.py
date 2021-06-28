from typing import List


class Solution:
    def reverseString(self, s: List[str]) -> None:
        for index in range(len(s) // 2):
            s[index], s[len(s) - index - 1] = s[len(s) - index - 1], s[index]
