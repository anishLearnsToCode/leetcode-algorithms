class Solution:
    def __init__(self):
        self.hex_chars = [str(i) for i in range(10)] + [chr(97 + i) for i in range(7)]

    def toHex(self, num: int) -> str:
        if num == 0:
            return '0'
        if num < 0:
            num = 2 ** 32 + num
        result = ''
        while num != 0:
            result = self.hex_chars[num & 15] + result
            num = (num >> 4)
        return result
