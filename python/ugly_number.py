class Solution:
    def eliminate_prime_factor(self, number: int, prime_factor: int) -> int:
        while number % prime_factor == 0 and number != 0:
            number //= prime_factor
        return number

    def isUgly(self, n: int) -> bool:
        n = self.eliminate_prime_factor(n, 2)
        n = self.eliminate_prime_factor(n, 3)
        n = self.eliminate_prime_factor(n, 5)
        return n == 1
