class Solution:
    def fib(self, n: int) -> int:
        prev, current = 0, 1
        for i in range(n):
            prev, current = current, prev + current
        return prev
