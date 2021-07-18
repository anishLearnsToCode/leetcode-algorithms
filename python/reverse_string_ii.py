class Solution:
    def reverseStr(self, s: str, k: int) -> str:
        result = ''
        index = 0
        while index < len(s):
            reverse_len = min(k, len(s) - index)
            for i in range(index + reverse_len - 1, index - 1, -1):
                result += s[i]
            index += k
            for i in range(index, index + k):
                if i >= len(s):
                    break
                result += s[i]
            index += k
        return result
