class Solution:
    def isAlphabet(self, character: str) -> bool:
        return self.isUpperCase(character) or self.isLowerCase(character)

    def isUpperCase(self, character: str) -> bool:
        return 65 <= ord(character) <= 90

    def isLowerCase(self, character: str) -> bool:
        return 97 <= ord(character) <= 122

    def toLowerCase(self, s: str) -> str:
        result = ''
        for character in s:
            result += chr(ord(character) + 32) if self.isAlphabet(character) and self.isUpperCase(character) else character
        return result
