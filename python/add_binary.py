class Solution:
    def addBinary(self, a: str, b: str) -> str:
        return bin(int(a, base=2) + int(b, base=2))[2:]

