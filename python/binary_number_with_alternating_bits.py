class Solution:
    def hasAlternatingBits(self, n: int) -> bool:
        lastDigit = n % 2
        while n > 0:
            n //= 2
            current = n % 2
            if lastDigit == current: return False
            lastDigit = current
        return True
