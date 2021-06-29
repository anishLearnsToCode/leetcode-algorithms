class Solution:
    def longestPalindrome(self, s: str) -> int:
        character_frequency = {}
        for character in s:
            character_frequency[character] = character_frequency.get(character, 0) + 1
        length = 0
        had_odd_length = False
        for frequency in character_frequency.values():
            if frequency % 2 == 0:
                length += frequency
            else:
                length += frequency - 1
                had_odd_length = True
        return length + int(had_odd_length)
