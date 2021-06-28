from string import digits
from typing import Dict


class Solution:
    def get_digit_frequency(self, number: str) -> Dict[str, int]:
        freq = {}
        for digit in number:
            freq[digit] = freq.get(digit, 0) + 1
        return freq

    def getHint(self, secret: str, guess: str) -> str:
        bulls = {}
        frequency_secret = self.get_digit_frequency(secret)
        frequency_guess = self.get_digit_frequency(guess)
        for s, g in zip(secret, guess):
            if s == g:
                bulls[s] = bulls.get(s, 0) + 1
        total_bulls = sum(bulls.values())
        total_cows = 0
        for i in digits:
            total_cows += min(frequency_secret.get(i, 0), frequency_guess.get(i, 0)) - bulls.get(i, 0)
        return f'{total_bulls}A{total_cows}B'
