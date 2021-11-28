public class BinaryGap {
    public int binaryGap(int n) {
        int result = Integer.MIN_VALUE, index = 0, prev = -1;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (prev == -1) prev = index;
                result = Math.max(result, index - prev);
                prev = index;
            }
            n >>= 1;
            index++;
        }
        return result;
    }
}
