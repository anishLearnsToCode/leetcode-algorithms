public class UglyNumber {
    public static boolean isUgly(int number) {
        if (number <= 0) {
            return false;
        }

        number = divideBy(number, 2);
        number = divideBy(number, 3);
        number = divideBy(number, 5);
        return number == 1;
    }

    private static int divideBy(int number, int primeFactor) {
        while (number % primeFactor == 0) {
            number /= primeFactor;
        }
        return number;
    }
}
