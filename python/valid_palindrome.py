import string


class Solution:
    def isPalindrome(self, s: str) -> bool:
        for x in string.punctuation:
            s = s.replace(x, '')

        s = s.replace(' ', '').lower()
        return s == s[::-1]
