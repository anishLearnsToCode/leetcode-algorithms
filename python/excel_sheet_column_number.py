class Solution:
    def titleToNumber(self, columnTitle: str) -> int:
        value = 0
        for character in columnTitle:
            value = 26 * value + ord(character) - 64
        return value
