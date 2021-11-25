class Solution:
    def __init__(self):
        self.isPrime = [
            0, 0, 1, 1, 0, 1, 0,
            1, 0, 0, 0, 1, 0,
            1, 0, 0, 0, 1, 0,
            1, 0, 0, 0, 1, 0
        ]

    def countPrimeSetBits(self, left: int, right: int) -> int:
        primeSetBits = 0
        for number in range(left, right + 1):
            if self.isPrime[self.setBits(number)] == 1:
                primeSetBits += 1
        return primeSetBits

    def setBits(self, number: int) -> int:
        result = 0
        while number > 0:
            result += number & 1
            number >>= 1
        return result
