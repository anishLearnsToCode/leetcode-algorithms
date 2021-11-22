class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        binarySubstrings, previous, current = 0, 0, 1
        index = 1
        while index < len(s):
            if s[index - 1] != s[index]:
                binarySubstrings += min(previous, current)
                previous, current = current, 1
            else: current += 1
            index += 1
        return binarySubstrings + min(previous, current)
