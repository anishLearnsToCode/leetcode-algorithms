from typing import Dict


class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        mapping = {}
        mapped_chars = set()
        for char_s, char_t in zip(s, t):
            if char_s in mapping:
                if mapping[char_s] != char_t:
                    return False
            else:
                if char_t in mapped_chars:
                    return False
                mapping[char_s] = char_t
                mapped_chars.add(char_t)
        return True
