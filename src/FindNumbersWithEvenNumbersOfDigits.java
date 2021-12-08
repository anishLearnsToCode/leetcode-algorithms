public class FindNumbersWithEvenNumbersOfDigits {
    public int findNumbers(int[] array) {
        int evenDigitNumbers = 0;
        for (int number : array) {
            if (numberOfDigits(number) % 2 == 0) evenDigitNumbers++;
        }
        return evenDigitNumbers;
    }

    private int numberOfDigits(int number) {
        if (number == 0) return 1;
        int digits = 0;
        while (number != 0) {
            number /= 10;
            digits++;
        }
        return digits;
    }
}
