from typing import List


class Solution:
    def __init__(self):
        self.alphabetPosition = {
            'q': 1,
            'w': 1,
            'e': 1,
            'r': 1,
            't': 1,
            'y': 1,
            'u': 1,
            'i': 1,
            'o': 1,
            'p': 1,
            'a': 2,
            's': 2,
            'd': 2,
            'f': 2,
            'g': 2,
            'h': 2,
            'j': 2,
            'k': 2,
            'l': 2,
            'z': 3,
            'x': 3,
            'c': 3,
            'v': 3,
            'b': 3,
            'n': 3,
            'm': 3,
        }

    def findWords(self, words: List[str]) -> List[str]:
        result = []
        for word in words:
            if self.singleRowWord(word.lower()):
                result.append(word)
        return result

    def singleRowWord(self, word: str) -> bool:
        row = self.alphabetPosition[word[0]]
        for index in range(1, len(word)):
            if self.alphabetPosition[word[index]] != row:
                return False
        return True
