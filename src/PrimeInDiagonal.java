// https://leetcode.com/problems/prime-in-diagonal
// m: number of rows in matrix
// n: size of numbers in matrix
// T: O(m * sqrt(n))
// S: O(1)

public class PrimeInDiagonal {
    public int diagonalPrime(int[][] nums) {
        final int rows = nums.length;
        int maxPrime = 0;
        // left to right diagonal
        for (int row = 0 ; row < rows ; row++) {
            if (row % 2 == 1 && row == rows / 2) {
                continue;
            }
            if (isPrime(nums[row][row])) {
                maxPrime = Math.max(maxPrime, nums[row][row]);
            }
        }

        // top right to bottom left diagonal
        for (int row = 0 ; row < rows ; row++) {
            if (isPrime(nums[row][rows - row - 1])) {
                maxPrime = Math.max(maxPrime, nums[row][rows - row - 1]);
            }
        }
        return maxPrime;
    }

    private boolean isPrime(int x) {
        if (x <= 1) return false;
        for (int i = 2 ; i * i <= x ; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
