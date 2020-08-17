public class PowerOf4 {
    public static boolean isPowerOfFour(int number) {
        if (number == 0) {
            return false;
        }

        while (number % 4 == 0) {
            number /= 4;
        }

        return number == 1;
    }
}
