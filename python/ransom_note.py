from typing import Dict


class Solution:
    def get_char_frequency(self, string: str) -> Dict[str, int]:
        frequency = {}
        for character in string:
            frequency[character] = frequency.get(character, 0) + 1
        return frequency

    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        magazine_characters = self.get_char_frequency(magazine)
        for character in ransomNote:
            if magazine_characters.get(character, 0) == 0:
                return False
            else:
                magazine_characters[character] -= 1
        return True
