class Solution:
    def isPalindrome(self, number: int) -> bool:
        number = str(number)
        for i in range(len(number) // 2):
            if number[i] != number[- (i + 1)]:
                return False
        return True
