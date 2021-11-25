public class PrimeNumberOfSetBitsInBinaryRepresentation {
    private final byte[] isPrime = new byte[] {0, 0, 1, 1, 0, 1, 0,
            1, 0, 0, 0, 1, 0,
            1, 0, 0, 0, 1, 0,
            1, 0, 0, 0, 1, 0
    };

    public int countPrimeSetBits(int left, int right) {
        int primeSetBits = 0;
        for (int number = left ; number <= right ; number++) {
            if (isPrime[setBits(number)] == 1) primeSetBits++;
        }
        return primeSetBits;
    }

    private int setBits(int number) {
        int setBits = 0;
        while (number > 0) {
            setBits += number & 1;
            number >>= 1;
        }
        return setBits;
    }
}
