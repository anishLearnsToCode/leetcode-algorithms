public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        int count;
        for (int i = 2 ; i * i <= c ; i++) {
            if (c % i == 0) {
                count = 0;
                while (c % i == 0) {
                    c /= i;
                    count++;
                }
                if (i % 4 == 3 && count % 2 == 1) return false;
            }
        }
        return true;
    }
}
