class Solution:
    def reverseBits(self, n: int) -> int:
        binary_str = bin(n)[2:]
        binary_str = '0' * (32 - len(binary_str)) + binary_str
        print(binary_str)
        reverse = binary_str[::-1]
        return int(reverse, base=2)
