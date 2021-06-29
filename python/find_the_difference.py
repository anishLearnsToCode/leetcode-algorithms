class Solution:
    def ascii_sum(self, string: str) -> int:
        return sum(ord(character) for character in string)

    def findTheDifference(self, s: str, t: str) -> str:
        return chr(self.ascii_sum(t) - self.ascii_sum(s))
