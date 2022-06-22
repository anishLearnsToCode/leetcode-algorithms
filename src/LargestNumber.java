// https://leetcode.com/problems/largest-number
// T: O(Nlog(N))
// S: O(N)

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {
    private static final String ZERO = "0";

    public static String largestNumber(int[] nums) {
        final List<String> numbers = convertToStrings(nums);
        numbers.sort((s1, s2) -> {
            final String order1 = s1 + s2;
            final String order2 = s2 + s1;
            return order2.compareTo(order1);
        });

        if (numbers.get(0).equals(ZERO)) return ZERO;
        return combineStrings(numbers);
    }

    private static String combineStrings(List<String> numbers) {
        final StringBuilder result = new StringBuilder();
        for (String string : numbers) {
            result.append(string);
        }
        return result.toString();
    }

    private static List<String> convertToStrings(int[] array) {
        final List<String> numbers = new ArrayList<>();
        for (int number : array) {
            numbers.add(String.valueOf(number));
        }
        return numbers;
    }
}
