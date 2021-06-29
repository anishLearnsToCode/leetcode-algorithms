class Solution:
    def firstUniqChar(self, s: str) -> int:
        frequencies = {}
        for index, character in enumerate(s):
            frequencies[character] = frequencies.get(character, 0) + 1
        for index, character in enumerate(s):
            if frequencies[character] == 1:
                return index
        return -1
