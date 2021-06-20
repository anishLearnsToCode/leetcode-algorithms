from typing import List


def plusOne(digits: List[int]) -> List[int]:
    carry = 1
    for index in range(len(digits) - 1, -1, -1):
        result = digits[index] + carry
        digits[index] = result % 10
        carry = result // 10
        if carry == 0:
            return digits
    return [1, *digits]


print(plusOne([int(digit) for digit in input()]))
