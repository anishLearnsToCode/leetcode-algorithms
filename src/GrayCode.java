// https://leetcode.com/problems/gray-code
// T: O(2 ^ n)
// S: O(2 ^ n)

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        final List<Integer> result = new ArrayList<>(1 << n);
        result.add(0);
        for (int i = 0, factor = 1 ; i < n ; i++, factor *= 2) {
            for (int j = factor - 1 ; j >= 0 ; j--) {
                result.add(result.get(j) + factor);
            }
        }
        return result;
    }
}
