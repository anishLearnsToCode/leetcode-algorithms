public class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n <= 2) return 1;
        int a = 0, b = 1, c = 1, temp;
        while (n - 2 > 0) {
            temp = c;
            c = a + b + c;
            a = b;
            b = temp;
            n--;
        }
        return c;
    }
}
