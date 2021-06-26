class Solution:
    def _is_happy(self, number: int, previously_used: set) -> bool:
        if number is 1:
            return True
        new_number = sum(int(digit) ** 2 for digit in str(number))
        if new_number in previously_used:
            return False
        previously_used.add(new_number)
        return self._is_happy(new_number, previously_used)

    def isHappy(self, n: int) -> bool:
        return self._is_happy(number=n, previously_used={n})
