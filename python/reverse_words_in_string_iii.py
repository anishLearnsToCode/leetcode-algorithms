class Solution:
    def reverseWords(self, s: str) -> str:
        result = ''
        for word in s.split():
            result += word[::-1] + ' '
        return result[:-1]
