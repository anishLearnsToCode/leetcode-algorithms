def mySqrt(x: int) -> int:
    left, right, ans = 0, x, 0
    while left <= right:
        middle = left + (right - left) // 2
        result = middle ** 2
        if result == x:
            return middle
        elif result > x:
            right = middle - 1
        else:
            ans = middle
            left = middle + 1
    return ans


# faster method, herons formula approach
def heron_approximation(x: int) -> int:
    if x is 0 or x is 1:
        return x
    guess = x / 2
    epsilon = 10 ** -4
    while True:
        new_guess = 0.5 * (guess + x / guess)
        if abs(guess - new_guess) < epsilon:
            return int(guess)
        guess = new_guess


# print(mySqrt(int(8)))

for i in range(50):
    print(f'sqrt({i})={mySqrt(i)}')
