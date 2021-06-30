class Solution:
    def str_to_int(self, number: str) -> int:
        value = 0
        for character in number:
            value = 10 * value + ord(character) - 48
        return value

    def int_to_str(self, number: int) -> str:
        if number == 0:
            return '0'
        value = ''
        while number > 0:
            value = str(number % 10) + value
            number //= 10
        return value

    def addStrings(self, num1: str, num2: str) -> str:
        return self.int_to_str(self.str_to_int(num1) + self.str_to_int(num2))
