public class CheckPerfectNumber {
    public boolean checkPerfectNumber(int number) {
        if (number == 1) return false;

        int sum = 0;
        for (int divisor = 2 ; divisor * divisor <= number ; divisor++) {
            if (number % divisor == 0) {
                sum += divisor + number / divisor;
            }
        }
        return sum + 1 == number;
    }
}
