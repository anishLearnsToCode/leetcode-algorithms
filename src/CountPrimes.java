public class CountPrimes {

    public static int countPrimes(int number) {
        boolean[] sieve = getSieve(number);
        return numberOfPrimes(sieve);
    }

    private static int numberOfPrimes(boolean[] array) {
        int count = 0;
        for (boolean value : array) {
            if (!value) count++;
        }
        return count;
    }

    private static boolean[] getSieve(int number) {
        if (number < 2) {
            return new boolean[0];
        }

        boolean[] sieve = new boolean[number];
        sieve[0] = sieve[1] = true;
        for (long index = 2 ; index < sieve.length ; index++){
            if (!sieve[(int) index]) {
                for (long j = index * index ; j < sieve.length ; j += index) {
                    sieve[(int) j] = true;
                }
            }
        }

        return sieve;
    }
}
