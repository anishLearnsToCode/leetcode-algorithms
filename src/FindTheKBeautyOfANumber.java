// https://leetcode.com/problems/find-the-k-beauty-of-a-number
// T: O(|num|)
// S: O(|num|)

public class FindTheKBeautyOfANumber {
    public int divisorSubstrings(int num, int k) {
        int kBeauty = 0;
        final String number = num + "";
        for (int index = 0 ; index < number.length() - k + 1 ; index++) {
            final String substring = number.substring(index, index + k);
            final int divisor = toNumber(substring);
            if (divisor != 0 && num % divisor == 0) kBeauty++;
        }
        return kBeauty;
    }

    private int toNumber(String string) {
        int result = 0;
        for (int i = 0; i < string.length() ; i++) {
            result = 10 * result + (string.charAt(i) - '0');
        }
        return result;
    }
}
