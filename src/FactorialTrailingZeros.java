public class FactorialTrailingZeros {
    public int trailingZeroes(int number) {
        int result = 0;
        while (number > 0) {
            result += number / 5;
            number /= 5;
        }
        return result;
    }
}
