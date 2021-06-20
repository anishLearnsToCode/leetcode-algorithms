def climbStairs(n: int) -> int:
    prev, current = 1, 1
    for i in range(n - 1):
        prev, current = current, prev + current
    return current
