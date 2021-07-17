public class FibonacciNumber {
    public int fib(int n) {
        int previous = 0, current = 1, temp1;
        for (int i = 0 ; i < n ; i++) {
            temp1 = current;
            current = previous + current;
            previous = temp1;
        }
        return previous;
    }
}
