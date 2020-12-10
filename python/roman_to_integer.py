class Solution:
    def __init__(self):
        self.romanNumerals = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000
        }

    def romanToInt(self, romanNumber: str) -> int:
        value = 0
        for index in range(len(romanNumber)):
            if index < len(romanNumber) - 1 and self.romanNumerals[romanNumber[index]] < self.romanNumerals[romanNumber[index + 1]]:
                value -= self.romanNumerals[romanNumber[index]]
            else:
                value += self.romanNumerals[romanNumber[index]]
        return value
