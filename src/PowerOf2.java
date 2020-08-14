public class PowerOf2 {
    public boolean isPowerOfTwo(int number) {
        if (number == 1) {
            return true;
        } else if (number % 2 == 1 || number == 0) {
            return false;
        }

        return isPowerOfTwo(number / 2);
    }
}
