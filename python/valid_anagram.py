from typing import Dict


class Solution:
    def character_frequency(self, string: str) -> Dict[str, int]:
        frequencies = {}
        for character in string:
            frequencies[character] = frequencies.get(character, 0) + 1
        return frequencies

    def isAnagram(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        char_freq_s = self.character_frequency(s)
        char_freq_t = self.character_frequency(t)
        return char_freq_s == char_freq_t
