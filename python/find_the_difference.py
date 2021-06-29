from typing import Dict


class Solution:
    def get_character_frequency(self, string: str) -> Dict[str, int]:
        frequency = {}
        for character in string:
            frequency[character] = frequency.get(character, 0) + 1
        return frequency

    def findTheDifference(self, s: str, t: str) -> str:
        characters_s = self.get_character_frequency(s)
        for character in t:
            if characters_s.get(character, 0) == 0:
                return character
            else:
                characters_s[character] -= 1
