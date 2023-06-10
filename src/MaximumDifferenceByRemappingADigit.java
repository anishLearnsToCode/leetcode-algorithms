// https://leetcode.com/problems/maximum-difference-by-remapping-a-digit
// T: O(log(N))
// S: O(1)

public class MaximumDifferenceByRemappingADigit {
    public int minMaxDifference(int num) {
        final String number = num + "";
        final int maxDigit = maxDigit(number);
        final int minDigit = minDigit(number);
        return maxDigit - minDigit;
    }

    private int maxDigit(String x) {
        for (int i = 0 ; i < x.length() ; i++) {
            int digit = x.charAt(i) - '0';
            if (digit < 9) {
                return changeOccurrence(x, digit, 9);
            }
        }
        return Integer.parseInt(x);
    }

    private int minDigit(String x) {
        for (int i = 0 ; i < x.length() ; i++) {
            int digit = x.charAt(i) - '0';
            if (digit != 0) {
                return changeOccurrence(x, digit, 0);
            }
        }
        return Integer.parseInt(x);
    }

    private int changeOccurrence(String x, int digit, int to) {
        final String result = x.replace((char) (digit + '0'), (char) (to + '0'));
        return Integer.parseInt(result);
    }
}
