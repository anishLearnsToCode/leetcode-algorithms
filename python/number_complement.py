class Solution:
    def highest_one_bit(self, i: int) -> int:
        i |= (i >> 1)
        i |= (i >> 2)
        i |= (i >> 4)
        i |= (i >> 8)
        i |= (i >> 16)
        return i - (i >> 1)

    def findComplement(self, number: int) -> int:
        return ~number & (self.highest_one_bit(number) - 1)

