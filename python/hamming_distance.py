class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        number = x ^ y
        bitCount = 0
        while number != 0:
            bitCount += number & 1
            number = number >> 1
        return bitCount
