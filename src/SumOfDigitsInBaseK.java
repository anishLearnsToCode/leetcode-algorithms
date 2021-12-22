public class SumOfDigitsInBaseK {
    public int sumBase(int n, int k) {
        return sumOfDigits(toBaseK(n, k));
    }

    private int sumOfDigits(StringBuilder number) {
        int sum = 0;
        for (int index = 0 ; index < number.length() ; index++) {
            sum += number.charAt(index) - '0';
        }
        return sum;
    }

    private StringBuilder toBaseK(int n, int k) {
        if (n == 0) return new StringBuilder("0");
        final StringBuilder result = new StringBuilder();
        while (n > 0) {
            result.append(n % k);
            n /= k;
        }
        return result.reverse();
    }
}
