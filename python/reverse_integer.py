class Solution:
    def reverse(self, number: int) -> int:
        neg = -1 if number < 0 else 1
        number = number * neg
        number = int(str(number)[::-1]) * neg
        if number not in range(- 2 ** 31, 2 ** 31):
            return 0
        else:
            return number
