class Solution:
    def checkPerfectNumber(self, num: int) -> bool:
        if num == 1: return False

        divisior_sum, divisior = 0, 1
        while divisior * divisior <= num:
            if num % divisior == 0:
                divisior_sum += (divisior + num // divisior)
            divisior += 1
        return divisior_sum == num
