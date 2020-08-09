import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        Stack<Integer> numbers = new Stack<>();
        int carry = 0;
        for (int index = digits.length - 1, factor = 1 ; index >= 0 ; index--) {
            int value = digits[index] + factor + carry;
            numbers.push(value % 10);
            carry = value / 10;
            factor = 0;
        }
        if (carry > 0) {
            numbers.push(carry);
        }

        int[] result = new int[numbers.size()];
        int index = 0;
        while (!numbers.isEmpty()) {
            result[index++] = numbers.pop();
        }
        return result;
    }
}
