// https://leetcode.com/problems/separate-the-digits-in-an-array
// T: O(N)
// S: O(N)

import java.util.ArrayList;
import java.util.List;

public class SeparateTheDigitsInAnArray {
    public int[] separateDigits(int[] nums) {
        final List<Integer> digits = new ArrayList<>();
        for (int number : nums) {
            addDigitsToList(digits, number);
        }
        return toArray(digits);
    }

    private int[] toArray(List<Integer> list) {
        final int[] array = new int[list.size()];
        for (int index = 0 ; index < list.size() ; index++) {
            array[index] = list.get(index);
        }
        return array;
    }

    private void addDigitsToList(List<Integer> digits, int number) {
        final String num = number + "";
        for (int index = 0 ; index < num.length() ; index++) {
            digits.add(num.charAt(index) - '0');
        }
    }
}
