public class Maximum69Number {
    public int maximum69Number (int num) {
        int result = 0;
        int divisor = 10_000;
        boolean changed = false;
        while (num > 0) {
            result *= 10;
            if (!changed && num / divisor == 6) {
                result += 9;
                changed = true;
            } else {
                result += num / divisor;
            }
            num -= (num / divisor) * divisor;
            divisor /= 10;
        }
        return result;
    }
}
