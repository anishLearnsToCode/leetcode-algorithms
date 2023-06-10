// https://leetcode.com/problems/split-with-minimum-sum
// T: O(log(N)log(log(N)))
// S: O(log(log(N)))

import java.util.ArrayList;
import java.util.List;

public class SplitWithMinimumSum {
    public int splitNum(int num) {
        final List<Integer> digits = getDigits(num);
        digits.sort(Integer::compareTo);
        int a = 0, b = 0, k = 0;
        for (int digit : digits) {
            if (k == 0) {
                a = 10 * a + digit;
            } else {
                b = 10 * b + digit;
            }
            k ^= 1;
        }
        return a + b;
    }

    private List<Integer> getDigits(int x) {
        final List<Integer> digits = new ArrayList<>();
        final String number = x + "";
        for (int index = 0 ; index < number.length() ; index++) {
            digits.add(number.charAt(index) - '0');
        }
        return digits;
    }
}
