class Solution:
    def repeatedSubstringPattern(self, pattern: str) -> bool:
        for length in range(1, len(pattern) // 2 + 1):
            if len(pattern) % length == 0:
                substring = pattern[:length]
                if self.patternComposedOf(pattern, substring):
                    return True
        return False

    def patternComposedOf(self, pattern: str, substring: str) -> bool:
        for i in range(len(pattern) // len(substring)):
            for j in range(len(substring)):
                if substring[j] != pattern[i * len(substring) + j]:
                    return False
        return True
