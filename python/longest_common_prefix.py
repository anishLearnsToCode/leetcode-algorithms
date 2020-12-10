from typing import List


class Solution:
    def longestCommonPrefix(self, array: List[str]) -> str:
        if len(array) == 0:
            return ''

        result = array[0]
        for index in range(1, len(array)):
            result = self.longestCommonPrefix2Strings(result, array[index])
        return result

    def longestCommonPrefix2Strings(self, first: str, second: str) -> str:
        for index in range(min(len(first), len(second))):
            if first[index] != second[index]:
                return first[0:index]

        return first if len(first) < len(second) else second
