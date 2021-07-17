import math


class Solution:
    def isPalindrome(self, number: int) -> bool:
        if number < 0: return False
        if number == 0: return True

        length = math.floor(math.log(number, 10) + 1)
        divisor = 10 ** (length - 1)
        modulo = 1
        for i in range(length // 2):
            left = (number // divisor) % 10
            right = (number % (10 * modulo)) // modulo
            if left != right:
                return False
            divisor //= 10
            modulo *= 10
        return True
