class Solution:
    def hammingWeight(self, number: int) -> int:
        binary = bin(number)
        count = 0
        for index in range(2, len(binary)):
            if int(binary[index]) == 1:
                count += 1
        return count

