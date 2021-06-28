class Solution:
    def addDigits(self, num: int) -> int:
        number_str = str(num)
        if len(number_str) == 1:
            return num
        return self.addDigits(sum(int(digit) for digit in number_str))
