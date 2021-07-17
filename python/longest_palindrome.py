class Solution:
    def isPalindrome(self, number: int) -> bool:
        if number == 0: return True
        if number % 10 == 0 or number < 0: return False

        right = 0
        while number > right:
            right = 10 * right + number % 10
            number //= 10
        return number == right or (number == right // 10)
