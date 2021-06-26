from typing import List


class Solution:
    def _get_prime_sieve(self, size: int) -> List[int]:
        sieve = [1] * (max(size, 2))
        sieve[0], sieve[1] = 0, 0
        for number in range(2, len(sieve)):
            if sieve[number]:
                for dividend in range(number ** 2, len(sieve), number):
                    sieve[dividend] = 0
        return sieve

    def countPrimes(self, n: int) -> int:
        return sum(self._get_prime_sieve(n))
