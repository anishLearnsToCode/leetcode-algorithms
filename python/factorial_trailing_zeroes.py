class Solution:
    def trailingZeroes(self, n: int) -> int:
        divisor, count = 5, 0
        while divisor <= n:
            count += n // divisor
            divisor *= 5
        return count
