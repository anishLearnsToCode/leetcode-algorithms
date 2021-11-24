from typing import List


class Solution:
    def isSelfDividing(self, number: int) -> bool:
        for digit in str(number):
            digit = int(digit)
            if digit == 0 or number % digit != 0:
                return False
        return True

    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        result = []
        for number in range(left, right + 1):
            if self.isSelfDividing(number):
                result.append(number)
        return result
