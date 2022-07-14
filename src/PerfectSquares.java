// https://leetcode.com/problems/perfect-squares
// T: O(k + sqrt(n)) k = size of perfect squares set which is constant
// S: O(k)

import java.util.Set;

public class PerfectSquares {
    private static final Set<Integer> PERFECT_SQUARES = Set.of(
            1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225, 256, 289, 324, 361, 400, 441, 484, 529, 576,
            625, 676, 729, 784, 841, 900, 961, 1024, 1089, 1156, 1225, 1296, 1369, 1444, 1521, 1600, 1681, 1764, 1849,
            1936, 2025, 2116, 2209, 2304, 2401, 2500, 2601, 2704, 2809, 2916, 3025, 3136, 3249, 3364, 3481, 3600, 3721,
            3844, 3969, 4096, 4225, 4356, 4489, 4624, 4761, 4900, 5041, 5184, 5329, 5476, 5625, 5776, 5929, 6084, 6241,
            6400, 6561, 6724, 6889, 7056, 7225, 7396, 7569, 7744, 7921, 8100, 8281, 8464, 8649, 8836, 9025, 9216, 9409,
            9604, 9801, 10_000, 10_201
    );

    private boolean isSquare(int n) {
        return PERFECT_SQUARES.contains(n);
    }

    // Based on Lagrange's Four Square theorem, there
    // are only 4 possible results: 1, 2, 3, 4.
    int numSquares(int n) {
        // If n is a perfect square, return 1.
        if (isSquare(n)) return 1;

        // The result is 4 if and only if n can be written in the
        // form of 4^k*(8*m + 7). Please refer to
        // Legendre's three-square theorem.
        while (n % 4 == 0) {
            n >>= 2;
        }
        if (n % 8 == 7) return 4;

        // Check whether 2 is the result. if number can be composed as a^2 + b^2
        for(int i = 1; i * i <= n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }

        return 3;
    }
}
