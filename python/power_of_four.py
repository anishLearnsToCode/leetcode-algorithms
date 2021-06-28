class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        if n <= 0:
            return False
        if n == 1:
            return True
        while n % 4 == 0:
            n //= 4
        return n == 1
