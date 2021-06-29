class Solution:
    # binary search method
    def isPerfectSquare(self, number: int) -> bool:
        if number == 1:
            return True
        left, right = 0, number // 2
        while left <= right:
            middle = (left + right) // 2
            mid_square = middle * middle
            if mid_square == number:
                return True
            elif mid_square < number:
                left = middle + 1
            else:
                right = middle - 1
        return False

    # Newton's Method
    # def isPerfectSquare(self, number: int) -> bool:
    #     r = number
    #     while r * r > number:
    #         r = (r + number / r) // 2
    #     return r * r == number

