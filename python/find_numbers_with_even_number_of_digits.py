from typing import List


class Solution:
    def findNumbers(self, nums: List[int]) -> int:
        evenDigitNumbers = 0
        for number in nums:
            if self.numberOfDigits(number) % 2 == 0:
                evenDigitNumbers += 1
        return evenDigitNumbers

    def numberOfDigits(self, number: int) -> int:
        if number == 0:
            return 1
        digits = 0
        while number != 0:
            number //= 10
            digits += 1
        return digits
