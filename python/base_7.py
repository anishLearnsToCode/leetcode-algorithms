class Solution:
    def convertToBase7(self, num: int) -> str:
        if num == 0:
            return '0'
        is_negative = num < 0
        num = -num if is_negative else num
        result = ''
        while num > 0:
            result = str(num % 7) + result
            num //= 7
        return ('-' if is_negative else '') +  result
