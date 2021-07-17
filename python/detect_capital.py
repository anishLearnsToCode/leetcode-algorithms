class Solution:
    def detectCapitalUse(self, word: str) -> bool:
        return word.isupper() or word.islower() or word[0].isupper() and self.isLower(word, 1)

    def isLower(self, word: str, start: int) -> bool:
        for index in range(start, len(word)):
            if word[index].isupper():
                return False
        return True
