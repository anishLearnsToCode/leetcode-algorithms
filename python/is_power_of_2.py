class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n == 1:
            return True
        if n == 0:
            return False
        if n % 2 == 1:
            return False
        return self.isPowerOfTwo(n // 2)

    # alternate version
    # def isPowerOfTwo(self, n: int) -> bool:
    #     return n > 0 and (n & (n - 1)) == 0