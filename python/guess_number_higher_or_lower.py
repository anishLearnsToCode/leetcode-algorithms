# The guess API is already defined for you.
# @param num, your guess
# @return -1 if my number is lower, 1 if my number is higher, otherwise return 0

def guess(num: int) -> int:
    # temp purposes
    return 0


class Solution:
    def guessNumber(self, n: int) -> int:
        left, right = 1, n
        while left <= right:
            middle = (left + right) // 2
            hypothesis = guess(middle)
            if hypothesis == 0:
                return middle
            elif hypothesis == 1:
                left = middle + 1
            else:
                right = middle - 1
        return 0
