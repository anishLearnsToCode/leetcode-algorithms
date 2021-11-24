from typing import List


class Solution:
    def __init__(self):
        self.primes = [
            2,  3,  5,  7, 11, 13, 17, 19, 23, 29, 31, 37,  41,
            43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101
    ]

    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        licenseHash = self.getHash(licensePlate)
        resultIndex, shortestLen = -1, float('inf')
        for index, word in enumerate(words):
            if len(word) < shortestLen and self.coversAllChars(word, licenseHash):
                resultIndex = index
                shortestLen = len(word)
        return words[resultIndex]

    def getHash(self, string: str) -> int:
        result = 1
        for char in string.lower():
            if char.isalpha():
                result *= self.primes[ord(char) - ord('a')]
        return result

    def coversAllChars(self, word: str, hash: int) -> bool:
        result = 1
        for character in word:
            result = (result * self.primes[ord(character) - ord('a')]) % hash
        return result == 0
