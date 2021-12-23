// https://leetcode.com/problems/three-divisors
// T: O(1)
// S: O(1)

public class ThreeDivisors {
    private static final PrimeSieve PRIME_SIEVE = PrimeSieve.ofSize(101);

    public boolean isThree(int n) {
        return isPerfectSquare(n);
    }

    private boolean isPerfectSquare(int x) {
        int sqrt = (int) Math.sqrt(x);
        return sqrt * sqrt == x && PRIME_SIEVE.isPrime(sqrt);
    }

    private static class PrimeSieve {
        final byte[] sieve;

        private static PrimeSieve ofSize(int size) {
            return new PrimeSieve(size);
        }

        PrimeSieve(int size) {
            this.sieve = new byte[size + 1];
            initializeSieve();
        }

        public boolean isPrime(int number) {
            return sieve[number] == 0;
        }

        private void initializeSieve() {
            sieve[0] = 1;
            sieve[1] = 1;
            for (int i = 2 ; i < sieve.length ; i++) {
                if (sieve[i] == 0) {
                    markFactors(i);
                }
            }
        }

        private void markFactors(int prime) {
            for (int i = prime * prime ; i < sieve.length ; i += prime) {
                sieve[i] = 1;
            }
        }
    }
}
