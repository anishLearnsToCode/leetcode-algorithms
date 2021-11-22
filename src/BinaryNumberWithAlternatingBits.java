public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int number) {
        int lastDigit = number % 2, current;
        while (number > 0) {
            number >>= 1;
            current = number % 2;
            if (lastDigit == current) return false;
            lastDigit = current;
        }
        return true;
    }
}
