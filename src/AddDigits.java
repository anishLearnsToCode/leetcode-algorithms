public class AddDigits {
    public static int addDigits(int number) {
        while (number > 9) {
            number = sumDigits(number);
        }
        return number;
    }

    private static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
